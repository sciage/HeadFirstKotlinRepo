package com.ajiew.headfirstkotlin.chap6Other

/**
 * Deconstruction statement
 * https://www.kotlincn.net/docs/reference/multi-declarations.html
 * */

data class Person(val name: String, val age: Int)

val person = Person("Aaron", 24)

/**
 * Deconstruction statement
 * */
fun showCase() {
    // A destructuring declaration creates multiple variables at the same time
    val (name, age) = person

    println("name = $name, age = $age")

    // Underscore is used for unused variables
    val (n, _) = person
    println(n)

    /**
     * The data class will automatically generate componentN functions for attributes, in the order of attribute declaration
     * */
    println(person.component1())
    println(person.component2())

    val strArr = mapOf("name" to "Aaron Chen", "age" to 24)
    /**
     * Use destructuring declaration to traverse the map
     * */
    for ((a, b) in strArr) {
        println("$a = $b")
    }

}

fun main() {
    showCase()
}