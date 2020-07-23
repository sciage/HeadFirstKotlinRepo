package com.ajiew.headfirstkotlin.chap3ClassAndObject
/**
 * Companion objects can be directly referenced, which is equivalent to static inner classes
 * https://www.kotlincn.net/docs/reference/object-declarations.html#%E4%BC%B4%E7%94%9F%E5%AF%B9%E8%B1%A1
 * */

class MyClass {

    val v = 1

    /**
     * The object declaration inside the class can be marked with the companion keyword
     * */
    companion object Factory {
// val copyV = v // Cannot access external class

        val whatever = "ok"

        fun create(): MyClass = MyClass()
    }

    override fun toString(): String {
        return "MyClass"
    }
}

/**
 * Even if the members of the companion object look like static members in other languages, they are still instance members of the real object at runtime, and, for example, can also implement interfaces
 * */
interface Factory<T> {
    fun create(): T
}

class MyClass2 {
    companion object: Factory<MyClass2> {
        override fun create(): MyClass2 = MyClass2()
    }
}

object Companion {

    @JvmStatic
    fun main(args: Array<String>) {
        /**
         * You can directly access the attributes and methods of the companion object
         * */
        println(MyClass.whatever)

        val instance = MyClass.create()
        println(instance.toString())

        /* The effect is the same as above, so the class name of the companion class can be omitted */
        val companion = MyClass.Factory.create()
        println(companion)
    }
}