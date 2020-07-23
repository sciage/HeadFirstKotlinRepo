package com.ajiew.headfirstkotlin.chap6Other
/**
 * Interval
 * https://www.kotlincn.net/docs/reference/ranges.html
 * */

fun showRangeTo() {
    /**
     * Use rangeTo function
     * */
    for (i in 1..10) print("$i, ")
    println()

    /**
     * !in corresponds to in
     * */
    val myAge = 25
    if (myAge !in 1..16) {
        println("$myAge years old does not belong to a teenage group")
    }

    /**
     * Reverse iteration downTo
     * */
    for (i in 10 downTo 1) print("$i, ")
    println()

    /**
     * Any step length iteration step
     * */
    for (i in 1..10 step 2) print("$i, ")
    println()

    for (i in 10 downTo 1 step 2) print("$i, ")
    println()

    /**
     * Does not include its ending element until
     * */
    // i in [1, 10) until 函数 排除了 10
    for (i in 1 until 10) print("$i, ")
}

fun main() {
    showRangeTo()
}