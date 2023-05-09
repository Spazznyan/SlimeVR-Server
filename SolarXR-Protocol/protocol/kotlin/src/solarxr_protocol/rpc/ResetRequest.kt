// automatically generated by the FlatBuffers compiler, do not modify

package solarxr_protocol.rpc

import java.nio.*
import kotlin.math.sign
import com.google.flatbuffers.*

@Suppress("unused")
class ResetRequest : Table() {

    fun __init(_i: Int, _bb: ByteBuffer)  {
        __reset(_i, _bb)
    }
    fun __assign(_i: Int, _bb: ByteBuffer) : ResetRequest {
        __init(_i, _bb)
        return this
    }
    val resetType : UByte
        get() {
            val o = __offset(4)
            return if(o != 0) bb.get(o + bb_pos).toUByte() else 0u
        }
    companion object {
        @JvmStatic
        fun validateVersion() = Constants.FLATBUFFERS_22_10_26()
        @JvmStatic
        fun getRootAsResetRequest(_bb: ByteBuffer): ResetRequest = getRootAsResetRequest(_bb, ResetRequest())
        @JvmStatic
        fun getRootAsResetRequest(_bb: ByteBuffer, obj: ResetRequest): ResetRequest {
            _bb.order(ByteOrder.LITTLE_ENDIAN)
            return (obj.__assign(_bb.getInt(_bb.position()) + _bb.position(), _bb))
        }
        @JvmStatic
        fun createResetRequest(builder: FlatBufferBuilder, resetType: UByte) : Int {
            builder.startTable(1)
            addResetType(builder, resetType)
            return endResetRequest(builder)
        }
        @JvmStatic
        fun startResetRequest(builder: FlatBufferBuilder) = builder.startTable(1)
        @JvmStatic
        fun addResetType(builder: FlatBufferBuilder, resetType: UByte) = builder.addByte(0, resetType.toByte(), 0)
        @JvmStatic
        fun endResetRequest(builder: FlatBufferBuilder) : Int {
            val o = builder.endTable()
            return o
        }
    }
}
