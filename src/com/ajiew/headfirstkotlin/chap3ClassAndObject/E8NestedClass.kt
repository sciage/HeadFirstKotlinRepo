package com.ajiew.headfirstkotlin.chap3ClassAndObject

/**
 * Nested and inner classes
 * https://www.kotlincn.net/docs/reference/nested-classes.html
 * */

class Outer {

    private val bar: String = "bar"

    private var listener: NestedListener? = null
        set(value) {
            if (value == null) {
                field = value
            }
        }

    /**
     * Ordinary nested class
     * */
    class Nested {
        fun foo(): String = "nested"

        fun bar() {
// println(bar) // nested class cannot access bar in outer class
        }
    }

    /**
     * Inner classes are identified by inner
     * */
    inner class Inner {
        fun foo() = bar

        fun bar() {
            println(bar) // can access bar
        }
    }

    fun addListener(listener: NestedListener) {
        this.listener = listener
    }
}

interface NestedListener {
    fun onClicked()

}

object NestedClass {

    @JvmStatic
    fun main(args: Array<String>) {
        val nested = Outer.Nested().foo()
        println(nested)

        val inner = Outer().Inner().foo()
        println(inner)

        val outer = Outer()
        /**
         * Use object expressions to create anonymous inner classes
         * */
        outer.addListener(object: NestedListener {

            override fun onClicked() {

            }
        })

        outer.Inner().bar()
    }
}