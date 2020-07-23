// 可以使用 @JvmName 注解修改生成的 Java 类的类名：
@file:JvmName("CallKotlinJvmName")

package com.ajiew.headfirstkotlin.chap7JavaInterop

/**
 * All functions and attributes declared in the Kotlin file, including extension functions,
 * Will be compiled into a static method of a Java class named package name.file name
 * */
class Foo

fun bar() {
    println("Do something")
}

// Java
//new demo.Foo();
//demo.ExampleKt.bar();

/**
 * Instance field
 * If you need to expose Kotlin attributes as fields in Java, you need to use the @JvmField annotation to mark them.
 * */
class Exposed(id: String) {
    @JvmField
    val ID = id
}

/**
 * Static field
 * Kotlin properties declared in a named object or companion object will have static behind-the-scenes fields in the named object or the class containing the companion object.
 * Usually these fields are private, but they can be exposed in one of the following ways:
 *-@JvmField annotation;
 *-lateinit modifier;
 *-const modifier.
 * */
class Key(val value: Int) {
    companion object {
        @JvmField
        val COMPARATOR: Comparator<Key> = compareBy { it.value }

        const val VERSION = 2
    }
}

object Singleton {
    lateinit var provider: String

    const val CONST = 1
}

const val MAX = 239

val someValue: String = "v"

fun main(args: Array<String>) {
    println(MAX)
    println(someValue)
}