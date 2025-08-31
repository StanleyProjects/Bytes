package sp.kx.bytes

internal fun Int.unsafeTest(index: Int): Boolean {
    return and(1.shl(index)) != 0
}
