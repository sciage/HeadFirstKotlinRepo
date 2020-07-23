package com.ajiew.headfirstkotlin.chap3ClassAndObject
/**
 * Interface
 * https://www.kotlincn.net/docs/reference/interfaces.html
 * */

/**
 * Declare the interface, the interface can have abstract attributes and method bodies
 * */
interface MyInterface {

    val prop: Int // abstract, subclass must be implemented, or provide accessor

    fun bar()
    fun foo() {
        // Optional method body, if there is a method body, the subclass does not have to be implemented
        println("foo in MyInterface")
    }
}

class MyInterfaceImpl: MyInterface {

    override val prop: Int = 29 // The subclass must override the abstract property

    override fun bar() {
        // method body
        println("bar in MyInterfaceImpl")
    }

    /**
     * foo can actually not be implemented
     * */
    override fun foo() {
        super.foo() // Similar to Java, the method in the calling interface uses super
        println("foo in MyInterfaceImpl")
    }
}

interface Named {
    val name: String
}

/**
 * Interface inheritance
 * */
interface Person: Named {
    val firstName: String
    val lastName: String

    // After the accessor is implemented, the subclass does not have to copy the abstract attribute
    override val name: String get() = "$firstName $lastName"
}

/**
 * Override variables in the parent class in the main constructor
 * */
data class Employee(
        // No need to implement "name" because the parent class already provides accessors
        override val firstName: String,
        override val lastName: String
): Person

/**
 * The following demonstrates the problem of inheriting multiple implementations of the same method in Kotlin
 * */
interface A {
    fun foo() {
        print("A")
    }

    fun bar()
}

interface B {
    fun foo() {
        print("B")
    }

    fun bar() {
        print("bar")
    }
}

/**
 * C inherits A, as long as the non-abstract class method bar() is implemented
 * */
class C: A {
    override fun bar() {
        print("bar")
    }
}

/**
 * D inherits A and B. When inheriting the foo() method, it will get different implementations in the two parent classes at the same time
 *
 * */
class D: A, B {
    override fun foo() {
        super<A>.foo() // Use the form of super<> to call the method in the parent class
        super<B>.foo()
    }

    override fun bar() {
        super<B>.bar() // Since only B implements bar, only the implementation in B can be called, which is equivalent to super.bar()
    }
}


object Interface {

    @JvmStatic
    fun main(args: Array<String>) {
        val impl = MyInterfaceImpl()
        println("Calling foo()=>")
        impl.foo()
        println("Calling bar()=>")
        impl.bar()
    }
}
