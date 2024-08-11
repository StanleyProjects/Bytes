package sp.kx.bytes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LongsTest {
    @Test
    fun toLongTest() {
        val expected: Long = 640125237199524901
        val b0: Byte = 0x08.toByte()
        val b1: Byte = 0xe2.toByte()
        val b2: Byte = 0x2e.toByte()
        val b3: Byte = 0x82.toByte()
        val b4: Byte = 0xff.toByte()
        val b5: Byte = 0x0a.toByte()
        val b6: Byte = 0x54.toByte()
        val b7: Byte = 0x25.toByte()
        val actual: Long = toLong(b0 = b0, b1 = b1, b2 = b2, b3 = b3, b4 = b4, b5 = b5, b6 = b6, b7 = b7)
        assertEquals(expected, actual)
    }

    @Test
    fun toByteArrayTest() {
        val number: Long = 0x0b323f24fdb0b21b
        val bytes = number.toByteArray()
        assertEquals(8, bytes.size)
        assertEquals(0x0b.toByte(), bytes[0])
        assertEquals(0x32.toByte(), bytes[1])
        assertEquals(0x3f.toByte(), bytes[2])
        assertEquals(0x24.toByte(), bytes[3])
        assertEquals(0xfd.toByte(), bytes[4])
        assertEquals(0xb0.toByte(), bytes[5])
        assertEquals(0xb2.toByte(), bytes[6])
        assertEquals(0x1b.toByte(), bytes[7])
    }
}
