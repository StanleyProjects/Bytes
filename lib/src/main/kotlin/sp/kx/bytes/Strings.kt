package sp.kx.bytes

import java.util.Locale

/**
 * The function converts an [Int] to hexadecimal [String] representation.
 *
 * Usage:
 * ```
 * val number: Int = 239
 * val expected = "ef"
 * assertEquals(expected, number.hex())
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
@Suppress("MagicNumber")
fun Int.hex(locale: Locale = Locale.US): String {
    return String.format(locale, "%02x", and(0xff))
}

/**
 * The function converts an [ByteArray] to hexadecimal [String] representation.
 *
 * Usage:
 * ```
 * val bytes = byteArrayOf(0x0a, 0x16, 0xe2, 0x36)
 * val expected = "0a16e236"
 * assertEquals(expected, bytes.hex())
 * ```
 * @author [Stanley Wintergreen](https://github.com/kepocnhh)
 * @since 0.1.0
 */
fun ByteArray.hex(locale: Locale = Locale.US): String {
    if (isEmpty()) return ""
    val builder = StringBuilder()
    builder.append(get(0).toInt().hex(locale))
    for (i in 1 until size) {
        builder.append(get(i).toInt().hex(locale))
    }
    return builder.toString()
}
