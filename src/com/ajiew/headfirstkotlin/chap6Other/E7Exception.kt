package com.ajiew.headfirstkotlin.chap6Other

import com.ajiew.headfirstkotlin.chap1Start.BasicSyntax.parseInt
/**
 * Abnormal
 * https://www.kotlincn.net/docs/reference/exceptions.html
 * */

/**
 * All exception classes in Kotlin are subclasses of Throwable class
 * */
fun throwException() {
    throw Exception("Hi There!")
}

/**
 * Use try-expression to catch exceptions
 * */
fun usingTryCatch() {
    try {
        throwException()
    } catch (e: Exception) {
        println(e.toString())
// e.printStackTrace()
    } finally {
        println("I'm done")
    }
}

/**
 * Try is an expression
 * The return value is the last expression in the try block or (all) the last expression in the catch block
 * */
fun tryAsExpression(input: String) {
    val a: Int? = try {
        parseInt(input) // If no exception is thrown, the return value is the legal return value of parseInt
    } catch (e: NumberFormatException) {
        null
    }
    println("the result is $a")
}

/**
 * Kotlin has no checked exceptions
 * */

/**
 * Nothing type
 * In Kotlin throw is an expression, so you can use it (for example) as part of an Elvis expression
 * The type of throw expression is the special type Nothing, which has no value, but is used to mark code positions that can never be reached
 * */
fun throwReturnNothing(person: NullablePerson) {
    val s = person.name ?: fail("Name Required")
    println(s) // Known here that "s" has been initialized
}

fun fail(message: String): Nothing {
    throw IllegalArgumentException(message)
}

fun typeInfer() {
    val x = null // "x" has type `Nothing?`
    if (x is Nothing?) println("x type is Nothing?")
    val l = listOf(null) // "l" has type `List<Nothing?>
}


fun main() {
//    throwException()

    usingTryCatch()

    tryAsExpression("1")

//    throwReturnNothing(NullablePerson(null))

    typeInfer()
}

class NullablePerson(val name: String?)