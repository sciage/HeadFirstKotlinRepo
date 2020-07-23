package com.ajiew.headfirstkotlin.chap3ClassAndObject

/**
 * Object expressions and object declarations
 * https://www.kotlincn.net/docs/reference/object-declarations.html
 * */

open class SomeParentClass {
    open fun someFun() {
        println("do some stuff here")
    }
}

/**
 * If we only need an anonymous object and do not need a special super type, then we can simply declare object.
 * */
fun objectDeclaration() {
    val adHoc = object {
        var x: Int = 0
        var y: Int = 0
    }
    print(adHoc.x + adHoc.y)
}

/**
 * Note that anonymous objects can be used as types declared only in local and private scopes.
 * */
class AnonymousObject {

    var flag = 0

    /**
     * Private function, so its return type is anonymous object type
     * */
    private fun foo() = object {
        val x: String = "x"

        /**
         * Just like Java anonymous inner classes, the code in the object expression can access variables from the scope that contains it.
         * */
        fun bar() {
            flag++
        }
    }

    /**
     * Public function, so its return type is Any
     * */
    fun publicFoo() = object {
        val x: String = "x"
    }

    fun bar() {
        val x1 = foo().x // No problem
// val x2 = publicFoo().x // Error: Unresolved reference "x"
    }

}

/**
 * object is followed by a name, which is called "object declaration". The generated object is called named object, which is singleton by default and thread-safe
 * */
object Objects {

    fun someFun() {
        println("someFun() do something here")
    }

    @JvmStatic
    fun main(args: Array<String>) {

        /**
         * Sometimes, we need to create an object of a class that has slightly changed a certain class without explicitly declaring a new subclass for it. Java uses anonymous inner classes to handle this situation.
         * You can use "object expressions" in Kotlin to do the same thing
         * */
        val another = object : SomeParentClass() {
            override fun someFun() {
                super.someFun()
                println("do some other stuff")
            }
        }


        someFun()

        another.someFun()
    }
}