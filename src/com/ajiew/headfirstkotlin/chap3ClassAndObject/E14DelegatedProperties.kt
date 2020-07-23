package com.ajiew.headfirstkotlin.chap3ClassAndObject

import kotlin.properties.Delegates
import kotlin.reflect.KProperty
/**
 * Delegation attributes
 * https://www.kotlincn.net/docs/reference/delegated-properties.html
 * */

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating'${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to'${property.name}' in $thisRef.")
    }
}

/**
 * There are some common attribute types. Although we can implement them manually every time we need them, it would be better if we can implement them only once for everyone and put them into a library.
 * Examples include:
 *-Lazy properties: its value is only calculated on the first visit;
 *-Observable properties: The listener will be notified of changes to this property;
 *-Store multiple attributes in a map instead of each in a separate field.
 * */
class Example {
    /**
     * The syntax is: val/var <attribute name>: <type> by <expression>
     * The expression after by is the delegate, because the get() and set() corresponding to the property will be delegated to its getValue() and setValue() methods.
     * Property delegates do not need to implement any interface, but need to provide a getValue() function (and setValue()-for var properties)
     * */
    var p: String by Delegate()

}

/**
 * 1. Delay attribute
 * lazy() is a function that accepts a lambda and returns an instance of Lazy<T>. The returned instance can be used as a delegate for implementing delayed properties.
 * By default, the evaluation of the lazy attribute is synchronized (synchronized)
 * */
val lazyValue: String by lazy {
    print("computed!")
    "Hello"
}

/**
 * 2. Observable
 * Delegates.observable() accepts two parameters: initial value and modification time handler (handler)
 * This handler is called whenever we assign a value to an attribute (executed after the assignment). It has three parameters: the attribute being assigned, the old value and the new value
 * */
class User {
    var name: String by Delegates.observable("<no name>") {prop, old, new ->
        println("$old -> $new")
    }
}

/**
 * Store the attributes in a map
 * */
class Student(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

val student = Student(mapOf(
        "name" to "Aaron Chen",
        "age" to 25
))

/**
 * This also applies to the var attribute, if the read-only Map is replaced by a MutableMap:
 * */
class MutableStudent(val map: MutableMap<String, Any>) {
    var name: String by map
    var age: Int by map
}

fun main() {
    val e = Example()
    /**
     * The getValue() function in Delegate will be called
     * */
    println(e.p)

    /**
     * The setValue() function in Delegate will be called
     * */
    e.p = "New Value"

    println(lazyValue) // computed!Hello
    println(lazyValue) // Hello

    val user = User()
    user.name = "first"
    user.name = "second"

    println(student.name) // Prints "John Doe"
    println(student.age)  // Prints 25

    val content = mutableMapOf(
        "name" to "Aaron Chen",
        "age" to 24)
    var mStu = MutableStudent(content)
    println("name: ${mStu.name}, age: ${mStu.age}")
}
