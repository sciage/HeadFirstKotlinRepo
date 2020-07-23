package com.ajiew.headfirstkotlin.chap3ClassAndObject

/**
 * Commission
 * https://www.kotlincn.net/docs/reference/delegation.html
 * */

/**
 * Kotlin has built-in support for delegation mode
 * */
interface Base {
    val message: String

    fun print()
    fun printMessage()
    fun printMessageLine()
}

class BaseImpl(val x: Int): Base {
    override val message = "Message of BaseImpl"

    /**
     * Cannot access the message in Derived
     * */
    override fun print() {println(message)}

    override fun printMessage() {
        print(x)
    }

    override fun printMessageLine() {
        println(x)
    }
}

/**
 * The by clause in the supertype list of Derived indicates that b will be stored internally in Derived, and the compiler will generate all Base methods forwarded to b.
 * */
class Derived(b: Base): Base by b {

    override val message = "Message of Derived"

    /**
     * Will cover the interface members implemented by the delegate
     * */
    override fun printMessage() {
        print("abc")
    }
}

fun main() {
    val b = BaseImpl(10)
    Derived(b).printMessage() // prints abc instead of 10
    Derived(b).printMessageLine() // print 10 and wrap
    println(Derived(b).message) // Message of Derived
    Derived(b).print() // Message of BaseImpl
}

