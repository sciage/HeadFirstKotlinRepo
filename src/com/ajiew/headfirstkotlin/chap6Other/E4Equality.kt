package com.ajiew.headfirstkotlin.chap6Other
/**
 * Equality
 * https://www.kotlincn.net/docs/reference/equality.html
 * */

/**
 * There are two types of equality in Kotlin
 *-The structure is equal, check with equals()
 *-References are equal, two references point to the same object
 * */
fun showStructureEqual() {
    val a = "a"
    val b = "a"

    val result = a == b
    println(result)
}

fun showReferenceEqual() {
    val a = "a"
    val b = "b"

    val result = a === b
    println(result)
}

fun main() {
    print("The structure is equal:")
    showStructureEqual()

    print("reference equal:")
    showReferenceEqual()
}
