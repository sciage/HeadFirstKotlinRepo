package com.ajiew.headfirstkotlin.chap2Basics
/**
 * <p>
 * Test the use of some basic APIs
 * </p>
 *
 * Standard library homepage https://kotlinlang.org/api/latest/jvm/stdlib/index.html
 *
 * Core methods and types https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/index.html
 *
 * Collection https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/index.html
 *
 * Math https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.math/index.html
 *
 * IO https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.io/index.html
 *
 * Multithreading https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.concurrent/index.html
 *
 * Coroutine https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.coroutines/index.html
 * */
fun main() {
    val map = mapOf(
        "name" to "Aaron Chen",
        "age" to 23
    )

    val mutableMap = mutableMapOf(
        "name" to "Kevin Chen",
        "age" to 24
    )
    println(map)
}