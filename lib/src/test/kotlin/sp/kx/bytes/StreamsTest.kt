package sp.kx.bytes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream

internal class StreamsTest {
    @Test
    fun writeBytesIntTest() {
        val number: Int = 0x0695e078
        val stream = ByteArrayOutputStream()
        stream.writeBytes(value = number)
        val bytes = stream.toByteArray()
        assertEquals(4, bytes.size)
        assertEquals(0x06.toByte(), bytes[0])
        assertEquals(0x95.toByte(), bytes[1])
        assertEquals(0xe0.toByte(), bytes[2])
        assertEquals(0x78.toByte(), bytes[3])
    }

    @Test
    fun readIntTest() {
        val bytes = byteArrayOf(
            0x05.toByte(),
            0x18.toByte(),
            0x9e.toByte(),
            0xe5.toByte(),
        )
        val stream = ByteArrayInputStream(bytes)
        val expected = 0x05189ee5
        assertEquals(expected, stream.readInt())
    }

    @Test
    fun writeIntReadTest() {
        val oStream = ByteArrayOutputStream()
        val expected = 0x05189ee5
        oStream.writeBytes(value = expected)
        val iStream = ByteArrayInputStream(oStream.toByteArray())
        assertEquals(expected, iStream.readInt())
    }
}
