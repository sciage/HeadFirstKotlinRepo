package com.ajiew.headfirstkotlin.chap3ClassAndObject
/**
 * Class constructor
 * https://www.kotlincn.net/docs/reference/classes.html#%E6%9E%84%E9%80%A0%E5%87%BD%E6%95%B0
 * */

/**
 * Declaring class attributes can directly add val or var to the main constructor, and the constructor keyword can be omitted, as long as there is no annotation or visibility modifier
 * */
open class People(val name: String){

    /**
     * The code in the initial code block will be executed before the secondary constructor
     * */
    init {
        println("My name is $name")
    }

    /**
     * Use name directly
     * */
    val nameLength = name.length

    /**
     * Class attributes cannot be declared in the secondary constructor, and you must first use this delegate to call the primary constructor or other secondary constructors, if the primary constructor exists (the default is empty)
     * */
    constructor(name: String, age: Int) :this(name) {
        println("and I have age")
    }

}


object Constructor{

    @JvmStatic
    fun main(args: Array<String>) {
        /**
         * There is no new keyword in Kotlin, just call the constructor of the class name directly
         * */
        val p1 = People("Aaron")
        println(p1.name)
        val p2 = People("Kevin", 24)
        println(p2.name)
    }
}