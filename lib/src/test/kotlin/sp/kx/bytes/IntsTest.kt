package sp.kx.bytes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class IntsTest {
    @Test
    fun toIntTest() {
        val expected: Int = 616889394
        val b0: Byte = 0x24.toByte()
        val b1: Byte = 0xc4.toByte()
        val b2: Byte = 0xfc.toByte()
        val b3: Byte = 0x32.toByte()
        val actual: Int = toInt(b0 = b0, b1 = b1, b2 = b2, b3 = b3)
        assertEquals(expected, actual)
    }
}
