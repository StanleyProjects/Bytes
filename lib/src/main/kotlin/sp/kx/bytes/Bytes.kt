package sp.kx.bytes

import java.util.UUID

@Suppress("MagicNumber")
fun ByteArray.readInt(index: Int = 0): Int {
    return get(index).toInt().and(0xff).shl(24)
        .or(get(index + 1).toInt().and(0xff).shl(16))
        .or(get(index + 2).toInt().and(0xff).shl(8))
        .or(get(index + 3).toInt().and(0xff))
}

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
