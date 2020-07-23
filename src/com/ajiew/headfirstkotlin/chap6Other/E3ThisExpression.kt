package com.ajiew.headfirstkotlin.chap6Other
/**
 * this expression
 * https://www.kotlincn.net/docs/reference/this-expressions.html
 * */

/**
 * In order to indicate the current receiver we use this expression:
 *-Among the members of a class, this refers to the current object of the class.
 *-In an extension function or a function literal with a receiver, this represents the **receiver** parameter passed on the left side of the dot.
 * */
fun showThis() {
    class A {// implicit label @A
    inner class B {// implicit label @B
    fun Int.foo() {// implicit label @foo
        val a = this@A // this of A
        val b = this@B // this of B

        println(a)
        println(b)

        val c = this // the receiver of foo(), an Int
        val c1 = this@foo // the receiver of foo(), an Int

        println(c)
        println(c1)

        val funLit = lambda@ fun String.() {
            val d = this // receiver of funLit
        }


        val funLit2 = {s: String ->
            // the receiver of foo() because of the lambda expression it contains
            // no receiver
            val d1 = this
        }
            }
        }

    }
}

fun main() {
    showThis()
}