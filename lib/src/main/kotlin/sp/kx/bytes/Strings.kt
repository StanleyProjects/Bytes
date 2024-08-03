package sp.kx.bytes

import java.util.Locale

fun Int.toHEX(locale: Locale = Locale.US): String {
    return String.format(locale, "%02x", and(0xff))
}

fun ByteArray.toHEX(locale: Locale = Locale.US): String {
    if (isEmpty()) return ""
    val builder = StringBuilder()
    builder.append(get(0).toInt().toHEX(locale))
    for (i in 1 until size) {
        builder.append(get(i).toInt().toHEX(locale))
    }
    return builder.toString()
}
