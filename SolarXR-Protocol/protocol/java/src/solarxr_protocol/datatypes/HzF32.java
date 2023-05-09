// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.datatypes;

import java.nio.*;
import java.lang.*;
import java.util.*;
import com.google.flatbuffers.*;

/**
 * Frequency as 32 bit float
 */
@SuppressWarnings("unused")
public final class HzF32 extends Struct {
  public void __init(int _i, ByteBuffer _bb) { __reset(_i, _bb); }
  public HzF32 __assign(int _i, ByteBuffer _bb) { __init(_i, _bb); return this; }

  public float f() { return bb.getFloat(bb_pos + 0); }

  public static int createHzF32(FlatBufferBuilder builder, float f) {
    builder.prep(4, 4);
    builder.putFloat(f);
    return builder.offset();
  }

  public static final class Vector extends BaseVector {
    public Vector __assign(int _vector, int _element_size, ByteBuffer _bb) { __reset(_vector, _element_size, _bb); return this; }

    public HzF32 get(int j) { return get(new HzF32(), j); }
    public HzF32 get(HzF32 obj, int j) {  return obj.__assign(__element(j), bb); }
  }
  public HzF32T unpack() {
    HzF32T _o = new HzF32T();
    unpackTo(_o);
    return _o;
  }
  public void unpackTo(HzF32T _o) {
    float _oF = f();
    _o.setF(_oF);
  }
  public static int pack(FlatBufferBuilder builder, HzF32T _o) {
    if (_o == null) return 0;
    return createHzF32(
      builder,
      _o.getF());
  }
}

