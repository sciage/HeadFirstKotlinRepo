package com.ajiew.headfirstkotlin.chap6Other

import com.ajiew.headfirstkotlin.chap3ClassAndObject.MyClass
import kotlin.reflect.KClass
/**
 * Reflection
 * https://www.kotlincn.net/docs/reference/reflection.html
 * */
fun showReflection() {
    val c = MyClass::class

    println(c is KClass)

    println(c.visibility)

    // To get a Java class reference, use the .java attribute
    println(c.java.name)

    val clazzRef = c::class.qualifiedName
    println(clazzRef)
}
fun main() {
    showReflection()
}