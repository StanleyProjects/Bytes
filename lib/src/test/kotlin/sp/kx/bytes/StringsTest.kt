package sp.kx.bytes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StringsTest {
    @Test
    fun hexIntTest() {
        mapOf(
            0 to "00",
            10 to "0a",
            42 to "2a",
            121 to "79",
            239 to "ef",
        ).forEach { (number, expected) ->
            assertEquals(expected, number.hex())
        }
    }

    @Test
    fun hexTest() {
        mapOf(
            byteArrayOf() to "",
            byteArrayOf(0) to "00",
            byteArrayOf(0x0a, 0x16, 0xe2.toByte(), 0x36) to "0a16e236",
        ).forEach { (bytes, expected) ->
            assertEquals(expected, bytes.hex())
        }
    }
}
