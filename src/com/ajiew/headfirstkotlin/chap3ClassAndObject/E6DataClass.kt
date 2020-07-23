package com.ajiew.headfirstkotlin.chap3ClassAndObject
/**
 * Data category
 * https://www.kotlincn.net/docs/reference/data-classes.html
 * */

/**
 * The compiler automatically derives the following members from all attributes declared in the main constructor:
 *-equals()/hashCode()
 *-toString() format is "User(name=John, age=42)"
 *-The componentN() function corresponds to all attributes in the order of declaration
 *-copy() function
 * */
data class Member(val name: String, val age: Int)

fun main() {
    val m = Member("Aaron", 25)
    println(m)

    println("Member name is ${m.name} and age is ${m.age}")

    println("componentN---------------")
    println(m.component1()) // name
    println(m.component2()) // age

    // Copy of data class
    val copied = m.copy()
    println(copied)

    // Deconstruction assignment of data class
    val (name, age) = m
    println("name = $name, age = $age")

    // Pair and Triple, Kotlin encapsulates the available data classes by default
    val pair = Pair("Aaron", 25)
    println("Using pair: name is ${pair.first}, age is ${pair.second}")

    val triple = Triple("Name", "Male", 25)
}