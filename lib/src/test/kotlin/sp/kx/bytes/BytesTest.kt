package sp.kx.bytes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BytesTest {
    @Test
    fun readIntTest() {
        val bytes = byteArrayOf(
            0x4d.toByte(),
            0x11.toByte(),
            0x24.toByte(),
            0xdd.toByte(),
            0xe8.toByte(),
        )
        assertEquals(1292969181, bytes.readInt())
        assertEquals(287628776, bytes.readInt(index = 1))
    }

    @Test
    fun readLongTest() {
        val bytes = byteArrayOf(
            0x5a.toByte(),
            0x07.toByte(),
            0xdf.toByte(),
            0x23.toByte(),
            0xbe.toByte(),
            0x32.toByte(),
            0x96.toByte(),
            0x32.toByte(),
            0xcd.toByte(),
        )
        assertEquals(6487399132858324530, bytes.readLong())
        assertEquals(567211377871434445, bytes.readLong(index = 1))
    }
}
