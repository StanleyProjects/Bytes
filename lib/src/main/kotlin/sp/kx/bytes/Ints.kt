package sp.kx.bytes

@Suppress("MagicNumber")
fun toInt(b0: Byte, b1: Byte, b2: Byte, b3: Byte): Int {
    return b0.toInt().and(0xff).shl(24)
        .or(b1.toInt().and(0xff).shl(16))
        .or(b2.toInt().and(0xff).shl(8))
        .or(b3.toInt().and(0xff))
}
