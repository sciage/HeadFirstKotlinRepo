package com.ajiew.headfirstkotlin.chap5Multiplatform
/**
 * Multi-platform
 * https://www.kotlincn.net/docs/reference/platform-specific-declarations.html
 * */

/**
 * Multi-platform is currently in experimental state and needs to be turned on to use
 * A common module can define expected declarations,
 * and a platform module can provide actual declarations corresponding to the expected ones.
 * */
/*
expect class Foo(bar: String) {
     fun frob()
}

actual class Foo actual constructor(val bar: String) {
     actual fun frob() {
         println("Frobbing the $bar")
     }
}

fun main() {
     Foo("Hello").frob()
}
*/