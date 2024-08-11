package sp.kx.bytes

/**
 * The function converts 4 [Byte]s into an [Int].
 *
 * Usage:
 * ```
 * val expected: Int = 287628776
 * val actual = toInt(0x11, 0x24, 0xdd, 0xe8)
 * assertEquals(expected, actual)
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
@Suppress("MagicNumber")
fun toInt(b0: Byte, b1: Byte, b2: Byte, b3: Byte): Int {
    return b0.toInt().and(0xff).shl(24)
        .or(b1.toInt().and(0xff).shl(16))
        .or(b2.toInt().and(0xff).shl(8))
        .or(b3.toInt().and(0xff))
}

fun Int.toByteArray(): ByteArray {
    val bytes = ByteArray(4)
    bytes.write(value = this)
    return bytes
}
