package com.ajiew.headfirstkotlin.chap2Basics
/**
 * basic type
 * https://www.kotlincn.net/docs/reference/basic-types.html
 * */

object BasicType {

    @JvmStatic
    fun main(args: Array<String>) {
        testNumbers()
    }

    fun testNumbers() {
        var num: Any
        num = 47
        println("show examples of converting numbers:")

        println(num is Int)
        println(num.toByte())
        println(num.toFloat())
        println(num.toString())

        println("String can be accessed directly by subscript")
        val name = "Aaron Chen"
        println("the sixth character in name is ${name[6]}")
        for (s in name) {
            print("$s ")
        }
    }
}