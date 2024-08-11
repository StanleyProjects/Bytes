package sp.kx.bytes

/**
 * The function converts 8 [Byte]s into an [Long].
 *
 * Usage:
 * ```
 * val expected: Long = 567211377871434445
 * val actual = toLong(0x07, 0xdf, 0x23, 0xbe, 0x32, 0x96, 0x32, 0xcd)
 * assertEquals(expected, actual)
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
@Suppress("MagicNumber", "LongParameterList")
fun toLong(b0: Byte, b1: Byte, b2: Byte, b3: Byte, b4: Byte, b5: Byte, b6: Byte, b7: Byte): Long {
    return b0.toLong().and(0xff).shl(56)
        .or(b1.toLong().and(0xff).shl(48))
        .or(b2.toLong().and(0xff).shl(40))
        .or(b3.toLong().and(0xff).shl(32))
        .or(b4.toLong().and(0xff).shl(24))
        .or(b5.toLong().and(0xff).shl(16))
        .or(b6.toLong().and(0xff).shl(8))
        .or(b7.toLong().and(0xff))
}

@Suppress("MagicNumber")
fun Long.toByteArray(): ByteArray {
    val bytes = ByteArray(8)
    bytes.write(value = this)
    return bytes
}
