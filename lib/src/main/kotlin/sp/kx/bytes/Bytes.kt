package sp.kx.bytes

import java.util.UUID

/**
 * The function converts 4 [Byte]s of [this] array starting at [index] into an [Int].
 *
 * Usage:
 * ```
 * val bytes = byteArrayOf(0x11, 0x24, 0xdd, 0xe8)
 * val expected: Int = 287628776
 * assertEquals(expected, bytes.readInt())
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
@Suppress("MagicNumber")
fun ByteArray.readInt(index: Int = 0): Int {
    return get(index).toInt().and(0xff).shl(24)
        .or(get(index + 1).toInt().and(0xff).shl(16))
        .or(get(index + 2).toInt().and(0xff).shl(8))
        .or(get(index + 3).toInt().and(0xff))
}

/**
 * The function converts 8 [Byte]s of [this] array starting at [index] into an [Long].
 *
 * Usage:
 * ```
 * val bytes = byteArrayOf(0x07, 0xdf, 0x23, 0xbe, 0x32, 0x96, 0x32, 0xcd)
 * val expected: Long = 567211377871434445
 * assertEquals(expected, bytes.readLong())
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
@Suppress("MagicNumber")
fun ByteArray.readLong(index: Int = 0): Long {
    return get(index).toLong().and(0xff).shl(56)
        .or(get(index + 1).toLong().and(0xff).shl(48))
        .or(get(index + 2).toLong().and(0xff).shl(40))
        .or(get(index + 3).toLong().and(0xff).shl(32))
        .or(get(index + 4).toLong().and(0xff).shl(24))
        .or(get(index + 5).toLong().and(0xff).shl(16))
        .or(get(index + 6).toLong().and(0xff).shl(8))
        .or(get(index + 7).toLong().and(0xff))
}

/**
 * The function converts 16 [Byte]s of [this] array starting at [index] into an [UUID] (as [UUID.mostSigBits] and [UUID.leastSigBits]).
 *
 * Usage:
 * ```
 * val bytes = byteArrayOf(0x01, 0x4d, 0x97, 0xa8, 0x89, 0x7e, 0x8d, 0x2c, 0x09, 0xb6, 0x83, 0x3d, 0xa2, 0x36, 0x17, 0xcf)
 * val expected = UUID.fromString("014d97a8-897e-8d2c-09b6-833da23617cf")
 * assertEquals(expected, bytes.readUUID())
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
@Suppress("MagicNumber")
fun ByteArray.readUUID(index: Int = 0): UUID {
    return UUID(readLong(index = index), readLong(index = index + 8))
}

@Suppress("MagicNumber")
fun ByteArray.write(index: Int = 0, value: Int) {
    set(index, value.shr(24).toByte())
    set(index + 1, value.shr(16).toByte())
    set(index + 2, value.shr(8).toByte())
    set(index + 3, value.toByte())
}

@Suppress("MagicNumber")
fun ByteArray.write(index: Int = 0, value: Long) {
    set(index, value.shr(56).toByte())
    set(index + 1, value.shr(48).toByte())
    set(index + 2, value.shr(40).toByte())
    set(index + 3, value.shr(32).toByte())
    set(index + 4, value.shr(24).toByte())
    set(index + 5, value.shr(16).toByte())
    set(index + 6, value.shr(8).toByte())
    set(index + 7, value.toByte())
}

@Suppress("MagicNumber")
fun ByteArray.write(index: Int = 0, value: UUID) {
    write(index = index, value = value.mostSignificantBits)
    write(index = index + 8, value = value.leastSignificantBits)
}
