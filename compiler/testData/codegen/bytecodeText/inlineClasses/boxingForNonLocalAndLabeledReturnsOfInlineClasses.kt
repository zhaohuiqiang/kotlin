// !LANGUAGE: +InlineClasses

inline class ULong(val l: Long)

fun nonLocal(): ULong? {
    val u = ULong(0)

    run {
        return u // box
    }

    TODO()
}

fun foo(): Boolean = true

fun labeled(): ULong? {
    val u = ULong(0)
    return run {
        if (foo()) return@run u
        u // box
    }
}

// 2 INVOKESTATIC ULong\$Erased.box
// 0 INVOKEVIRTUAL ULong.unbox

// 0 valueOf
// 0 intValue