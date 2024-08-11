package sp.kx.bytes

import java.io.InputStream
import java.io.OutputStream
import java.util.UUID

@Suppress("MagicNumber")
fun OutputStream.writeBytes(value: Int) {
    write(value.shr(24))
    write(value.shr(16))
    write(value.shr(8))
    write(value)
}

@Suppress("MagicNumber")
fun InputStream.readInt(): Int {
    return read().and(0xff).shl(24)
        .or(read().and(0xff).shl(16))
        .or(read().and(0xff).shl(8))
        .or(read().and(0xff))
}

@Suppress("MagicNumber")
fun OutputStream.writeBytes(value: Long) {
    write(value.shr(56).toInt())
    write(value.shr(48).toInt())
    write(value.shr(40).toInt())
    write(value.shr(32).toInt())
    write(value.shr(24).toInt())
    write(value.shr(16).toInt())
    write(value.shr(8).toInt())
    write(value.toInt())
}

@Suppress("MagicNumber")
fun InputStream.readLong(): Long {
    return read().toLong().and(0xff).shl(56)
        .or(read().toLong().and(0xff).shl(48))
        .or(read().toLong().and(0xff).shl(40))
        .or(read().toLong().and(0xff).shl(32))
        .or(read().toLong().and(0xff).shl(24))
        .or(read().toLong().and(0xff).shl(16))
        .or(read().toLong().and(0xff).shl(8))
        .or(read().toLong().and(0xff))
}

fun OutputStream.writeBytes(value: UUID) {
    writeBytes(value = value.mostSignificantBits)
    writeBytes(value = value.leastSignificantBits)
}

fun InputStream.readUUID(): UUID {
    return UUID(readLong(), readLong())
}

fun InputStream.readBytes(size: Int): ByteArray {
    val bytes = ByteArray(size)
    read(bytes)
    return bytes
}
