package sp.kx.bytes

interface Transformer<T : Any> {
    fun encode(decoded: T): ByteArray
    fun decode(encoded: ByteArray): T
}
