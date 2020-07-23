package com.ajiew.headfirstkotlin.chap3ClassAndObject

/**
 * Inline function
 * https://www.kotlincn.net/docs/reference/inline-classes.html
 * */

/**
 * The main purpose of inline classes is to package certain data, such as some basic data types. Using inline classes can be more efficient than using general data classes
 * */
inline class Password(val value: String)

/**
 * Limitations of inline classes:
 *-No init code block
 *-Cannot have inner classes
 *-Cannot have behind-the-scenes attributes
 * */
object InlineClass {

    @JvmStatic
    fun main(args: Array<String>) {
        val securePassword = Password("Don't try this in production")
        println(securePassword)

        println(securePassword.value)

        /* The inline class will be compiled into the type it contains */
        println(securePassword.javaClass.name) // String
    }
}