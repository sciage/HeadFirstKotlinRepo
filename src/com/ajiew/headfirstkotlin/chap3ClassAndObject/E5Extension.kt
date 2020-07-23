package com.ajiew.headfirstkotlin.chap3ClassAndObject
/**
 * Class extension
 * https://www.kotlincn.net/docs/reference/extensions.html
 * */

/**
 * Extensions are generally written at the top level, we can add some Util methods to some classes through extensions
 * */
object Extension {

    /**
     * Extend MutableList to add a swap method
     * */
    fun <T> MutableList<T>.swap(index1: Int, index2: Int) {
        val tmp = this[index1]
        this[index1] = this[index2]
        this[index2] = tmp
    }

    /**
     * Extended attributes
     * */
    val <T> List<T>.lastIndex: Int
        get() = size-1

    @JvmStatic
    fun main(args: Array<String>) {
        val list = mutableListOf('1', '2', '3')
        /**
         * By defining an extension, you are not inserting new members in a class
         * It's just that this new function can be called with a dot expression through this type of variable
         * */
        list.swap(0, 2)
        println(list)

        /**
         * Call extended attributes
         * */
        println("last index is ${list.lastIndex}")

        /**
         * The extension function in ExtensionA is always called
         * */
        printFoo(ExtensionB())

        main()
    }

    /**
     * Extended declaration as a member
     * */
    class A {
        fun bar() {}
    }

    /**
     * Inside a class you can declare extensions for another class
     * */
    class B {
        fun baz() {}

        /**
         * At this time, B is the distribution receiver, and A is the extended receiver
         * */
        fun A.foo() {
            bar() // calls A.bar
            baz() // calls B.baz

            // extended receiver priority
            toString() // call A.toString()
            this@B.toString() // call B.toString()
        }
    }

    /**
     * Extended receiver
     * */
    open class D

    class D1: D()

    /**
     * Distribution recipient
     * */
    open class C {
        open fun D.foo() {
            println("D.foo in C")
        }

        open fun D1.foo() {
            println("D1.foo in C")
        }

        fun caller(d: D) {
            d.foo() // call the extension function
        }
    }

    class C1: C() {
        override fun D.foo() {
            println("D.foo in C1")
        }

        override fun D1.foo() {
            println("D1.foo in C1")
        }

    }

    fun main() {
        // call the extension of D in C
        C().caller(D()) // output "D.foo in C"

        // Call the extension of D in C1 to distribute receiver virtual analysis
        C1().caller(D()) // output "D.foo in C1"

        // Call the extension of D in C, and the extension receiver statically resolves
        C().caller(D1()) // output "D.foo in C"
    }
}

open class ExtensionA

class ExtensionB: ExtensionA()

fun ExtensionA.foo() = "ExtensionA"

fun ExtensionB.foo() = "ExtensionB"

fun printFoo(a: ExtensionA) {
    /**
     * The extension is statically resolved
     *
     * This means that the extended function called is determined by the type of expression in which the function is called, not by the result of the evaluation of the expression at runtime.
     * */
    println(a.foo())
}
