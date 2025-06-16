package sp.kx.bytes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class IntsTest {
    @Test
    fun toInt4Test() {
        val expected: Int = 616889394
        val b0: Byte = 0x24.toByte()
        val b1: Byte = 0xc4.toByte()
        val b2: Byte = 0xfc.toByte()
        val b3: Byte = 0x32.toByte()
        val actual: Int = toInt(b0 = b0, b1 = b1, b2 = b2, b3 = b3)
        assertEquals(expected, actual)
    }

    @Test
    fun toInt2Test() {
        val expected: Int = 0x3039
        val b0: Byte = 0x30
        val b1: Byte = 0x39
        val actual: Int = toInt(b0 = b0, b1 = b1)
        assertEquals(expected, actual)
    }

    @Test
    fun toInt2ReversedTest() {
        val expected: Int = 0x0aef
        val b0: Byte = 0xef.toByte()
        val b1: Byte = 0x0a.toByte()
        val actual: Int = toInt(b1, b0)
        assertEquals(expected, actual)
    }

    @Test
    fun toByteArrayTest() {
        val number: Int = 0x0695e078
        val bytes = number.toByteArray()
        assertEquals(4, bytes.size)
        assertEquals(0x06.toByte(), bytes[0])
        assertEquals(0x95.toByte(), bytes[1])
        assertEquals(0xe0.toByte(), bytes[2])
        assertEquals(0x78.toByte(), bytes[3])
    }
}
