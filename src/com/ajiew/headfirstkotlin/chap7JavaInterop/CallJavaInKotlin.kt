package com.ajiew.headfirstkotlin.chap7JavaInterop

import java.util.*

/**
 * Call Java code in Kotlin
 * https://www.kotlincn.net/docs/reference/java-interop.html
 * */

/**
 * Copy list to Java's ArrayList, which is equivalent to Kotlin's MutableList
 * */
fun callList(source: List<String>) {
    val list = java.util.ArrayList<String>()
    // "for"-loops for Java collections:
    for (item in source) {
        list.add(item)
    }
    // The operator conventions are also valid:
    for (i in 0 until source.size) {
        list[i] = source[i] // call get and set
    }
}

/**
 * Java agreed getter and setter methods are accessed as attributes in kotlin
 * */
fun calendarDemo() {
    val calendar = Calendar.getInstance()
    if (calendar.firstDayOfWeek == Calendar.SUNDAY) {// call getFirstDayOfWeek()
        calendar.firstDayOfWeek = Calendar.MONDAY // call ll setFirstDayOfWeek()
    }
    if (!calendar.isLenient) {// call isLenient()
        calendar.isLenient = true // call setLenient()
    }
}

/**
 * If Java identifiers are keywords in Kotlin, they need to be escaped with ``
 * */
fun callWithEscape() {
    val d = DummyJavaClass()
    d.`is`()
}

fun main() {
    callList(listOf("a", "b", "c"))

    calendarDemo()

    callWithEscape()
}