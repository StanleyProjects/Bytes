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

/**
 * The function converts 2 [Byte]s into an [Int].
 *
 * Usage:
 * ```
 * val expected: Int = 0x3039
 * val actual = toInt(0x30, 0x39)
 * assertEquals(expected, actual)
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.0
 */
@Suppress("MagicNumber")
fun toInt(b0: Byte, b1: Byte): Int {
    return b0.toInt().and(0xff).shl(8)
        .or(b1.toInt().and(0xff))
}

/**
 * The function converts [this]: [Int] into 4 [Byte]s and puts them into a [ByteArray].
 *
 * Usage:
 * ```
 * val expected: Int = 0x0695e078
 * val bytes = expected.toByteArray()
 * assertEquals(expected, bytes.readInt())
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.2.1
 */
@Suppress("MagicNumber")
fun Int.toByteArray(): ByteArray {
    val bytes = ByteArray(4)
    bytes.write(value = this)
    return bytes
}

/**
 * The function checks that at [index] the bit is equal to `1`.
 *
 * Usage:
 * ```
 * val number = 0b00000001
 * assertTrue(number.test(index = 0))
 * assertFalse(number.test(index = 1))
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.4.0
 */
@Suppress("MagicNumber")
fun Int.test(index: Int): Boolean {
    require(index in 0..31) { "Unexpected index $index!" }
    return unsafeTest(index = index)
}
