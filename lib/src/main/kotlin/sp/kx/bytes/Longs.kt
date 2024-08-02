package sp.kx.bytes

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
