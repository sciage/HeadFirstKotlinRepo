package com.ajiew.headfirstkotlin.chap1Start

import com.ajiew.headfirstkotlin.chap3ClassAndObject.Whatever
/**
 * Basic grammar
 * https://www.kotlincn.net/docs/reference/basic-syntax.html
 *
 * All syntax
 * https://www.kotlincn.net/docs/reference/grammar.html
 *
 * Keywords and operators
 * https://www.kotlincn.net/docs/reference/keyword-reference.html
 * */

fun out() {
    println("out method")
}

object BasicSyntax {

    /**
     * Constant
     * */
    val PI = 3.14

    /**
     * Variable
     * */
    var age = 24

    /**
     * this is documentation comment
     * */
    @JvmStatic
    fun main(args: Array<String>) {
        // The above is equivalent to
        // fun main(var arg args: String) {// var arg means variable arguments is the variable parameter list in Java
        out()

        // this is line comment
        val str = "123456"

        val nullable: Int?
// println(nullable) // cannot print because it has not been initialized
        nullable = 666
        println(nullable)

        /* this is block commend */
        println("Hello World!")

        // After declaring a variable, use :Type to indicate the variable type, which can also be omitted due to type inference
        var age: Int = 24
        println(age)

        // In Kotlin, if is an expression, it returns a value
        val old = if (age> 80) "old" else "not old"

        val x = 1
        val y = 3

// val z = x * y // Warning is not allowed on a nullable receiver

            // After null detection, x and y will be automatically converted to non-nullable values ​​(non-nullable)
            println(x * y)
      //  }

        useLiteral()

        val des = useWhen(1)
        println(des)

        useRange(29)

        useStep()

        useDownto()

        useCollection()

        useDataClass()

        val w = Whatever()
        println(w.half)
    }

    /**
     * Method declaration, the type is after: and the return value is after the method parameters
     * */
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    /* no return value (Unit is like void in Java) */
    fun printSum(a: Int, b: Int): Unit {
        println("sum of $a and $b is ${a + b}")
    }

    /* return a nullable value */
    fun parseInt(str: String): Int? {
        return 1
    }

    /* String template */
    fun useLiteral() {
        var a = 1
        // Simple name in the template:
        val s1 = "a is $a"

        a = 2
        // Any expression in the template:
        val s2 = "${s1.replace("$a", "b")}, but now is $a"
        println(s2)
    }

    fun useIs(obj: Any): Int? {
        if (obj is String) {
            // `obj` is automatically converted to `String` in this conditional branch
            return obj.length
        }

        // After leaving the type detection branch, `obj` is still of type `Any`
        return null
    }

    fun useWhen(obj: Any): String = when (obj) {
        1 -> "One"
        "Hello" -> "Greeting"
        is Long -> "Long"
        !is String -> "Not a string"
        else -> "Unknown"
    }

    fun useRange(x: Int) {
        if (x in 24..35)
            println("Young")
        else
            println("Unknown")
    }

    fun useStep() {
        for (i in 2..9 step 2) {
            if (i % 2 == 0)
                println("$i is an even number")
        }
    }

    fun useDownto() {
        for (i in 99 downTo 90 step 2) {
            if (i % 2 != 0)
                println("$i is an odd number")
        }
    }

    fun useCollection() {
        val fruits = listOf("banana", "avocado", "apple", "kiwifruit")
        fruits
            .filter { it.startsWith("a") }
            .sortedBy { it }
            .map { it.toUpperCase() }
            .forEach { println(it) }
    }

    fun useDataClass() {
        val customer = Customer("aaron", "kevin10tod@gmail.com")
        println("Customer: name = ${customer.name}, email = ${customer.email}")
    }
}