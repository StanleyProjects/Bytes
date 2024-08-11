package sp.kx.bytes

import java.io.InputStream
import java.io.OutputStream

fun OutputStream.writeBytes(value: Int) {
    write(value.shr(24))
    write(value.shr(16))
    write(value.shr(8))
    write(value)
}

fun InputStream.readInt(): Int {
    return read().and(0xff).shl(24)
        .or(read().and(0xff).shl(16))
        .or(read().and(0xff).shl(8))
        .or(read().and(0xff))
}
