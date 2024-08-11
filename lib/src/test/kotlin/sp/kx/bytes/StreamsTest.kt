package sp.kx.bytes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.util.UUID

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

    @Test
    fun writeBytesLongTest() {
        val expected: Long = 0x0b323f24fdb0b21b
        val stream = ByteArrayOutputStream()
        stream.writeBytes(value = expected)
        val bytes = stream.toByteArray()
        check(bytes.size == 8)
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
    fun readLongTest() {
        val bytes = byteArrayOf(
            0x07.toByte(),
            0xdf.toByte(),
            0x23.toByte(),
            0xbe.toByte(),
            0x32.toByte(),
            0x96.toByte(),
            0x32.toByte(),
            0xcd.toByte(),
        )
        check(bytes.size == 8)
        val stream = ByteArrayInputStream(bytes)
        val expected: Long = 0x07df23be329632cd
        assertEquals(expected, stream.readLong())
    }

    @Test
    fun writeLongReadTest() {
        val oStream = ByteArrayOutputStream()
        val expected: Long = 0x07df23be329632cd
        oStream.writeBytes(value = expected)
        val iStream = ByteArrayInputStream(oStream.toByteArray())
        assertEquals(expected, iStream.readLong())
    }

    @Test
    fun writeUUIDTest() {
        val expected = UUID.fromString("9fe2ec8c-3ecb-4b29-b622-4f23a981d8fb")
        val stream = ByteArrayOutputStream()
        stream.writeBytes(value = expected)
        val bytes = stream.toByteArray()
        check(bytes.size == 16)
        assertEquals(0x9f.toByte(), bytes[0])
        assertEquals(0xe2.toByte(), bytes[1])
        assertEquals(0xec.toByte(), bytes[2])
        assertEquals(0x8c.toByte(), bytes[3])
        assertEquals(0x3e.toByte(), bytes[4])
        assertEquals(0xcb.toByte(), bytes[5])
        assertEquals(0x4b.toByte(), bytes[6])
        assertEquals(0x29.toByte(), bytes[7])
        assertEquals(0xb6.toByte(), bytes[8])
        assertEquals(0x22.toByte(), bytes[9])
        assertEquals(0x4f.toByte(), bytes[10])
        assertEquals(0x23.toByte(), bytes[11])
        assertEquals(0xa9.toByte(), bytes[12])
        assertEquals(0x81.toByte(), bytes[13])
        assertEquals(0xd8.toByte(), bytes[14])
        assertEquals(0xfb.toByte(), bytes[15])
    }

    @Test
    fun readUUIDTest() {
        val bytes = byteArrayOf(
            0x1b.toByte(),
            0x01.toByte(),
            0x4d.toByte(),
            0x97.toByte(),
            0xa8.toByte(),
            0x89.toByte(),
            0x7e.toByte(),
            0x8d.toByte(),
            0x2c.toByte(),
            0x09.toByte(),
            0xb6.toByte(),
            0x83.toByte(),
            0x3d.toByte(),
            0xa2.toByte(),
            0x36.toByte(),
            0x17.toByte(),
        )
        check(bytes.size == 16)
        val stream = ByteArrayInputStream(bytes)
        assertEquals(UUID.fromString("1b014d97-a889-7e8d-2c09-b6833da23617"), stream.readUUID())
    }

    @Test
    fun readBytesTest() {
        val bytes = byteArrayOf(
            0x1b.toByte(), // 00
            0x01.toByte(), // 01
            0x4d.toByte(), // 02
            0x97.toByte(), // 03
            0x7f.toByte(), // 04
            0x89.toByte(), // 05
            0x7e.toByte(), // 06
            0x8d.toByte(), // 07
            0x2c.toByte(), // 08
            0x09.toByte(), // 09
            0xb6.toByte(), // 10
            0x83.toByte(), // 11
            0x3d.toByte(), // 12
            0xa2.toByte(), // 13
            0x36.toByte(), // 14
            0x17.toByte(), // 15
        )
        check(bytes.size == 16)
        ByteArrayInputStream(bytes).also { stream ->
            val expected: Int = 0x7f897e8d
            val size = 8
            val actual = stream.readBytes(size = size)
            assertEquals(size, actual.size)
            assertEquals(expected, actual.readInt(index = 4))
        }
    }
}
