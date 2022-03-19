package dev.slimevr.vr.trackers;

import java.util.LinkedList;
import com.jme3.math.FastMath;
import com.jme3.math.Quaternion;
import com.jme3.math.Vector3f;

import dev.slimevr.vr.trackers.udp.TrackersUDPServer;
import io.eiren.util.BufferedTimer;

public class IMUTracker implements Tracker, TrackerWithTPS, TrackerWithBattery {
	
	public static final float MAX_MAG_CORRECTION_ACCURACY = 5 * FastMath.RAD_TO_DEG;
	
	//public final Vector3f gyroVector = new Vector3f();
	//public final Vector3f accelVector = new Vector3f();
	public final Vector3f magVector = new Vector3f();
	public final Quaternion rotQuaternion = new Quaternion();
	public final Quaternion rotMagQuaternion = new Quaternion();
	public final Quaternion rotAdjust = new Quaternion();
	protected final Quaternion correction = new Quaternion();
	protected LinkedList<Quaternion> previousRots = new LinkedList<Quaternion>();
	protected TrackerMountingRotation mounting = null;
	protected TrackerStatus status = TrackerStatus.OK;
	protected final int trackerId;
	
	protected final String name;
	protected final String descriptiveName;
	protected final TrackersUDPServer server;
	protected float confidence = 0;
	protected float batteryVoltage = 0;
	protected float batteryLevel = 0;
	public int calibrationStatus = 0;
	public int magCalibrationStatus = 0;
	public float magnetometerAccuracy = 0;
	protected boolean magentometerCalibrated = false;
	public boolean hasNewCorrectionData = false;
	
	protected BufferedTimer timer = new BufferedTimer(1f);
	public int ping = -1;
	public int signalStrength = -1;
	public float temperature = 0;
	
	public TrackerPosition bodyPosition = null;
	
	public IMUTracker(int trackerId, String name, String descriptiveName, TrackersUDPServer server) {
		this.name = name;
		this.server = server;
		this.trackerId = trackerId;
		this.descriptiveName = descriptiveName;
	}
	
	@Override
	public void saveConfig(TrackerConfig config) {
		config.setDesignation(bodyPosition == null ? null : bodyPosition.designation);
		config.mountingRotation = mounting != null ? mounting.name() : null;
	}
	
	@Override
	public void loadConfig(TrackerConfig config) {
		// Loading a config is an act of user editing, therefore it shouldn't not be allowed if editing is not allowed
		if (userEditable()) {
			if(config.mountingRotation != null) {
				try{
					mounting = TrackerMountingRotation.valueOf(config.mountingRotation);
				}
				catch (Exception e){ // FORWARD was renamed to FRONT
					mounting = TrackerMountingRotation.FRONT;
					config.mountingRotation = "FRONT";
				}
				if(mounting != null) {
					rotAdjust.set(mounting.quaternion);
				} else {
					rotAdjust.loadIdentity();
				}
			} else {
				rotAdjust.loadIdentity();
			}
			bodyPosition = TrackerPosition.getByDesignation(config.designation);
		}
	}
	
	public TrackerMountingRotation getMountingRotation() {
		return mounting;
	}
	
	public void setMountingRotation(TrackerMountingRotation mr) {
		mounting = mr;
		if(mounting != null) {
			rotAdjust.set(mounting.quaternion);
		} else {
			rotAdjust.loadIdentity();
		}
	}
	
	@Override
	public void tick() {
		if(magentometerCalibrated && hasNewCorrectionData) {
			hasNewCorrectionData = false;
			if(magnetometerAccuracy <= MAX_MAG_CORRECTION_ACCURACY) {
				// Adjust gyro rotation to match magnetometer rotation only if magnetometer
				// accuracy is within the parameters
				calculateLiveMagnetometerCorrection();
			}
		}
		previousRots.addLast(new Quaternion(rotQuaternion));
		if(previousRots.size() > 2){ // How far back in will getFilteredRotation go to get oldRot
			previousRots.removeFirst();
		}
	}
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public boolean getPosition(Vector3f store) {
		store.set(0, 0, 0);
		return false;
	}
	
	@Override
	public boolean getRotation(Quaternion store) {
		float filterFactor = 1f; // 1 = do nothing, >0<1 = interpolation, >1 = exterpolation
		store.set(getFilteredRotation(rotQuaternion, previousRots.getFirst(), filterFactor));
		//correction.mult(store, store); // Correction is not used now to prevent accidental errors while debugging other things
		store.multLocal(rotAdjust);
		return true;
	}

	// Original code: https://answers.unity.com/questions/168779/extrapolating-quaternion-rotation.html
	Quaternion getFilteredRotation(Quaternion latestRot, Quaternion oldRot, float factor){
		Quaternion rot = oldRot.mult(latestRot.inverse());
		while (factor > 1){
			oldRot = latestRot;
			latestRot = latestRot.mult(rot);
			factor -= 1;
		}
		Quaternion filteredQuaternion = new Quaternion();
		filteredQuaternion = filteredQuaternion.slerp(oldRot, latestRot, factor);
		return filteredQuaternion;
	}
	
	public void getCorrection(Quaternion store) {
		store.set(correction);
	}

	@Override
	public TrackerStatus getStatus() {
		return status;
	}
	
	public void setStatus(TrackerStatus status) {
		this.status = status;
	}
	
	@Override
	public float getTPS() {
		return timer.getAverageFPS();
	}
	
	@Override
	public void dataTick() {
		timer.update();
	}
	
	@Override
	public float getConfidenceLevel() {
		return confidence;
	}
	
	public void setConfidence(float newConf) {
		this.confidence = newConf;
	}
	
	@Override
	public float getBatteryLevel() {
		return batteryLevel;
	}
	
	@Override
	public float getBatteryVoltage() {
		return batteryVoltage;
	}
	
	public void setBatteryLevel(float level) {
		this.batteryLevel = level;
	}

	public void setBatteryVoltage(float voltage) {
		this.batteryVoltage = voltage;
	}

	@Override
	public void resetFull(Quaternion reference) {
		resetYaw(reference);
	}

	/**
	 * Does not perform actual gyro reset to reference, that's the task of
	 * reference adjusted tracker. Only aligns gyro with magnetometer if
	 * it's reliable
	 */
	@Override
	public void resetYaw(Quaternion reference) {
		if(magCalibrationStatus >= CalibrationAccuracy.HIGH.status) {
			magentometerCalibrated = true;
			// During calibration set correction to match magnetometer readings exactly
			// TODO : Correct only yaw
			correction.set(rotQuaternion).inverseLocal().multLocal(rotMagQuaternion);
		}
	}
	
	/**
	 * Calculate correction between normal and magnetometer
	 * readings up to accuracy threshold
	 */
	protected void calculateLiveMagnetometerCorrection() {
		// TODO Magic, correct only yaw
		// TODO Print "jump" length when correcting if it's more than 1 degree
	}

	@Override
	public TrackerPosition getBodyPosition() {
		return bodyPosition;
	}

	@Override
	public void setBodyPosition(TrackerPosition position) {
		this.bodyPosition = position;
	}

	@Override
	public boolean userEditable() {
		return true;
	}

	@Override
	public boolean hasRotation() {
		return true;
	}

	@Override
	public boolean hasPosition() {
		return false;
	}

	@Override
	public boolean isComputed() {
		return false;
	}

	@Override
	public int getTrackerId() {
		return this.trackerId;
	}
	
	@Override
	public String getDescriptiveName() {
		return this.descriptiveName;
	}
	
	public enum CalibrationAccuracy {
		
		UNRELIABLE(0),
		LOW(1),
		MEDIUM(2),
		HIGH(3),
		;
		
		private static final CalibrationAccuracy[] byStatus = new CalibrationAccuracy[4];
		public final int status;
		
		private CalibrationAccuracy(int status) {
			this.status = status;
		}
		
		public static CalibrationAccuracy getByStatus(int status) {
			if(status < 0 || status > 3)
				return null;
			return byStatus[status];
		}
		
		static {
			for(CalibrationAccuracy ca : values())
				byStatus[ca.status] = ca;
		}
	}
}
