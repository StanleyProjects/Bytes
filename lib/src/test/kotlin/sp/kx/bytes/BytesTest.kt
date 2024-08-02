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

    @Test
    fun writeIntTest() {
        val bytes = ByteArray(8)
        check(bytes.all { it == 0.toByte() })
        val expected: Int = 32406059
        bytes.write(value = expected)
        assertEquals(0x01.toByte(), bytes[0])
        assertEquals(0xee.toByte(), bytes[1])
        assertEquals(0x7a.toByte(), bytes[2])
        assertEquals(0x2b.toByte(), bytes[3])
    }

    @Test
    fun writeIntIndexedTest() {
        val bytes = ByteArray(1 + 8)
        check(bytes.all { it == 0.toByte() })
        val expected: Int = 527148540
        bytes.write(index = 1, value = expected)
        assertEquals(0x00.toByte(), bytes[0])
        assertEquals(0x1f.toByte(), bytes[1])
        assertEquals(0x6b.toByte(), bytes[2])
        assertEquals(0xa5.toByte(), bytes[3])
        assertEquals(0xfc.toByte(), bytes[4])
    }

    @Test
    fun writeLongTest() {
        val bytes = ByteArray(16)
        check(bytes.all { it == 0.toByte() })
        val expected: Long = 806776711360328219
        bytes.write(value = expected)
        assertEquals(0x0b.toByte(), bytes[0])
        assertEquals(0x32.toByte(), bytes[1])
        assertEquals(0x3f.toByte(), bytes[2])
        assertEquals(0x24.toByte(), bytes[3])
        assertEquals(0xfd.toByte(), bytes[4])
        assertEquals(0xb0.toByte(), bytes[5])
        assertEquals(0xb2.toByte(), bytes[6])
        assertEquals(0x1b.toByte(), bytes[7])
    }

    @Test
    fun writeLongIndexedTest() {
        val bytes = ByteArray(1 + 16)
        check(bytes.all { it == 0.toByte() })
        val expected: Long = 551244811269033501
        bytes.write(index = 1, value = expected)
        assertEquals(0x00.toByte(), bytes[0])
        assertEquals(0x07.toByte(), bytes[1])
        assertEquals(0xa6.toByte(), bytes[2])
        assertEquals(0x6a.toByte(), bytes[3])
        assertEquals(0x3c.toByte(), bytes[4])
        assertEquals(0x37.toByte(), bytes[5])
        assertEquals(0xf7.toByte(), bytes[6])
        assertEquals(0xce.toByte(), bytes[7])
        assertEquals(0x1d.toByte(), bytes[8])
    }
}
