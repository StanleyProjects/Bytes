package sp.kx.bytes

fun ByteArray.readInt(index: Int = 0): Int {
    return get(index).toInt().and(0xff).shl(24)
        .or(get(index + 1).toInt().and(0xff).shl(16))
        .or(get(index + 2).toInt().and(0xff).shl(8))
        .or(get(index + 3).toInt().and(0xff))
}

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
