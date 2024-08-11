package sp.kx.bytes

import java.io.InputStream
import java.io.OutputStream
import java.util.UUID

/**
 * The function writes [value]: [Int] into [this]: [OutputStream] as 4 [Byte]s.
 *
 * Usage:
 * ```
 * val expected: Int = 0x0695e078
 * val stream = ByteArrayOutputStream()
 * stream.writeBytes(value = expected)
 * assertEquals(expected, stream.toByteArray().readInt())
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.0
 */
@Suppress("MagicNumber")
fun OutputStream.writeBytes(value: Int) {
    write(value.shr(24))
    write(value.shr(16))
    write(value.shr(8))
    write(value)
}

/**
 * The function converts 4 [Byte]s of [this]: [InputStream] into an [Int].
 *
 * Usage:
 * ```
 * val expected: Int = 0x0695e078
 * val bytes = ByteArray(4)
 * bytes.write(value = expected)
 * val stream = ByteArrayInputStream(bytes)
 * assertEquals(expected, stream.readInt())
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.0
 */
@Suppress("MagicNumber")
fun InputStream.readInt(): Int {
    return read().and(0xff).shl(24)
        .or(read().and(0xff).shl(16))
        .or(read().and(0xff).shl(8))
        .or(read().and(0xff))
}

/**
 * The function writes [value]: [Long] into [this]: [OutputStream] as 8 [Byte]s.
 *
 * Usage:
 * ```
 * val expected: Long = 0x0b323f24fdb0b21b
 * val stream = ByteArrayOutputStream()
 * stream.writeBytes(value = expected)
 * assertEquals(expected, stream.toByteArray().readLong())
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.0
 */
@Suppress("MagicNumber")
fun OutputStream.writeBytes(value: Long) {
    write(value.shr(56).toInt())
    write(value.shr(48).toInt())
    write(value.shr(40).toInt())
    write(value.shr(32).toInt())
    write(value.shr(24).toInt())
    write(value.shr(16).toInt())
    write(value.shr(8).toInt())
    write(value.toInt())
}

/**
 * The function converts 8 [Byte]s of [this]: [InputStream] into a [Long].
 *
 * Usage:
 * ```
 * val expected: Long = 0x0b323f24fdb0b21b
 * val bytes = ByteArray(8)
 * bytes.write(value = expected)
 * val stream = ByteArrayInputStream(bytes)
 * assertEquals(expected, stream.readLong())
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.0
 */
@Suppress("MagicNumber")
fun InputStream.readLong(): Long {
    return read().toLong().and(0xff).shl(56)
        .or(read().toLong().and(0xff).shl(48))
        .or(read().toLong().and(0xff).shl(40))
        .or(read().toLong().and(0xff).shl(32))
        .or(read().toLong().and(0xff).shl(24))
        .or(read().toLong().and(0xff).shl(16))
        .or(read().toLong().and(0xff).shl(8))
        .or(read().toLong().and(0xff))
}

/**
 * The function writes [value]: [UUID] into [this]: [OutputStream] as 16 [Byte]s.
 *
 * Usage:
 * ```
 * val expected = UUID.fromString("9fe2ec8c-3ecb-4b29-b622-4f23a981d8fb")
 * val stream = ByteArrayOutputStream()
 * stream.writeBytes(value = expected)
 * assertEquals(expected, stream.toByteArray().readUUID())
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.0
 */
fun OutputStream.writeBytes(value: UUID) {
    writeBytes(value = value.mostSignificantBits)
    writeBytes(value = value.leastSignificantBits)
}

/**
 * The function converts 16 [Byte]s of [this]: [InputStream] into an [UUID].
 *
 * Usage:
 * ```
 * val expected = UUID.fromString("9fe2ec8c-3ecb-4b29-b622-4f23a981d8fb")
 * val bytes = ByteArray(16)
 * bytes.write(value = expected)
 * val stream = ByteArrayInputStream(bytes)
 * assertEquals(expected, stream.readUUID())
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.0
 */
fun InputStream.readUUID(): UUID {
    return UUID(readLong(), readLong())
}

/**
 * The function read [size] bytes of [this]: [InputStream] into a new [ByteArray].
 *
 * Usage:
 * ```
 * val bytes = ByteArray(8)
 * bytes.write(value = 0x0b323f24fdb0b21b)
 * val stream = ByteArrayInputStream(bytes)
 * val actual = stream.readBytes(size = 4)
 * assertEquals(0x0b323f24, actual.readInt())
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.0
 */
fun InputStream.readBytes(size: Int): ByteArray {
    val bytes = ByteArray(size)
    read(bytes)
    return bytes
}
