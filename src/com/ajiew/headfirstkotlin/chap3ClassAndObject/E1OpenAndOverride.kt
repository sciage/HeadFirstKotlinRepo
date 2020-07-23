package com.ajiew.headfirstkotlin.chap3ClassAndObject

/**
 * Class inheritance and initialization
 * https://www.kotlincn.net/docs/reference/classes.html#%E7%BB%A7%E6%89%BF
 * */

/**
 * Use the open keyword to allow subclasses to inherit
 * */
open class Human /*@Inject public*/ constructor(name: String) {
    /**
     * The parameters in the main constructor can be accessed in the initial code block
     * */
    init {
        println("First initializer block that prints $name")
    }

    /**
     * Can also be used in the property initializer
     * */
    val firstName = name.toUpperCase()

    fun sayName() {
        println("My name is ${this.javaClass}")
    }
}

/**
 * If the main constructor has no visibility modifier or annotation, you can omit the constructor keyword
 * */
open class Father(name: String): Human(name) {
    /**
     * The method must use the open subclass to rewrite
     * */
    open fun job() {
        println("I'm ${Father::class.simpleName}, I'm a cooker")
    }
}

/**
 * If the parent class contains a constructor, then the subclass must initialize the constructor when inheriting
 * */
class Son(name: String, val age: Int): Father(name) {

    init {
        println("init block in Son for $name")
    }

    /**
     * The secondary constructor must delegate to the primary constructor
     * */
    constructor(name: String, age: Int, sex: String): this(name, age) {
        println("initiated with sex")
    }

    /**
     * Inheritance methods must use the override keyword
     * */
    override fun job() {
        super.job()
        println("I'm ${Son::class.simpleName}, I'm an advanced cooker")
    }
}

/**
 * Of course, it can also be initialized by the secondary constructor
 * */
class Daughter: Human {
    constructor(name: String): super(name)
}

/**
 * If all the parameters of the main constructor have default values, the compiler will generate an additional parameterless constructor, which will use the default values
 * */
class Customer(val customerName: String = "No One")

/**
 * Abstract class
 * */
abstract class Store {

    val name = "Store"

    /**
     * Abstract method
     * */
    fun sayStoreName() {
        println(name)
    }

    abstract fun showGoods()
}

class GroceryStore : Store() {
    override fun showGoods() {
        println("Food Section")
        println("Living Things Section")
        println("Other Stocks Section")
    }

}


object OpenAndOverride {

    @JvmStatic
    fun main(args: Array<String>) {
        val son = Son("Kevin", 25, "M")
        son.job()

        println()

        val c = Customer()
        println(c.customerName)
    }
}
