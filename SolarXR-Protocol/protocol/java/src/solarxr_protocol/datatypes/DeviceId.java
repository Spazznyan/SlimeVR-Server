// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.datatypes;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * A unique ID for the device. IDs are not guaranteed to be the same after
 * the connection is terminated.
 */
@SuppressWarnings("unused")
public final class DeviceId extends Struct {
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public DeviceId __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public int id() { return bb.get(bb_pos + 0) & 0xFF; }

  public static int createDeviceId(FlatBufferBuilder builder, int id) {
    builder.prep(1, 1);
    builder.putByte((byte) id);
    return builder.offset();
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public DeviceId get(int j) { return get(new DeviceId(), j); }
    public DeviceId get(DeviceId obj, int j) {  return obj.__assign(__element(j), bb); }
  }
  public DeviceIdT unpack() {
    DeviceIdT _o = new DeviceIdT();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(DeviceIdT _o) {
    int _oId = id();
    _o.setId(_oId);
  }
  public static int pack(FlatBufferBuilder builder, DeviceIdT _o) {
    if (_o == null) return 0;
    return createDeviceId(
      builder,
      _o.getId());
  }
}

