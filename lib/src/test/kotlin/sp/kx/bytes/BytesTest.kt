package sp.kx.bytes

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.util.UUID

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
            0xcf.toByte(),
        )
        assertEquals(UUID.fromString("1b014d97-a889-7e8d-2c09-b6833da23617"), bytes.readUUID())
        assertEquals(UUID.fromString("014d97a8-897e-8d2c-09b6-833da23617cf"), bytes.readUUID(index = 1))
    }

    @Test
    fun writeIntTest() {
        val bytes = ByteArray(4)
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
        val bytes = ByteArray(1 + 4)
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
        val bytes = ByteArray(8)
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
        val bytes = ByteArray(1 + 8)
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

    @Test
    fun writeUUIDTest() {
        val bytes = ByteArray(16)
        check(bytes.all { it == 0.toByte() })
        val expected = UUID.fromString("9fe2ec8c-3ecb-4b29-b622-4f23a981d8fb")
        bytes.write(value = expected)
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
    fun writeUUIDIndexedTest() {
        val bytes = ByteArray(1 + 16)
        check(bytes.all { it == 0.toByte() })
        val expected = UUID.fromString("ff0db9c3-5f86-4602-be53-4abb1f0088d7")
        bytes.write(index = 1, value = expected)
        assertEquals(0x00.toByte(), bytes[0])
        assertEquals(0xff.toByte(), bytes[1])
        assertEquals(0x0d.toByte(), bytes[2])
        assertEquals(0xb9.toByte(), bytes[3])
        assertEquals(0xc3.toByte(), bytes[4])
        assertEquals(0x5f.toByte(), bytes[5])
        assertEquals(0x86.toByte(), bytes[6])
        assertEquals(0x46.toByte(), bytes[7])
        assertEquals(0x02.toByte(), bytes[8])
        assertEquals(0xbe.toByte(), bytes[9])
        assertEquals(0x53.toByte(), bytes[10])
        assertEquals(0x4a.toByte(), bytes[11])
        assertEquals(0xbb.toByte(), bytes[12])
        assertEquals(0x1f.toByte(), bytes[13])
        assertEquals(0x00.toByte(), bytes[14])
        assertEquals(0x88.toByte(), bytes[15])
        assertEquals(0xd7.toByte(), bytes[16])
    }

    @Test
    fun toByteArrayTest() {
        val id = UUID.fromString("9fe2ec8c-3ecb-4b29-b622-4f23a981d8fb")
        val bytes = id.toByteArray()
        assertEquals(16, bytes.size)
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
}
