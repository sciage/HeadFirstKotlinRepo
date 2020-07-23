package com.ajiew.headfirstkotlin.chap3ClassAndObject

import kotlin.random.Random
/**
 * Generic
 * https://www.kotlincn.net/docs/reference/generics.html
 * */

/**
 * Declaration change: use out or in modifier. We can annotate the type parameter T of Source to ensure that it is only returned (produced) from the Source<T> member and never consumed.
 * The general principle is: When the type parameter T of a class Class is declared as out, it can only appear in the output-position of the members of Class.
 * But the reward is that Class<Base> can be safely used as a superclass of Class<Derived>. You can think of Class as a producer of T, not a consumer of T.
 * */
interface Source<out T> {
    fun nextT(): T
}

class Origin: Source<String> {
    override fun nextT(): String {
        return "S" + Random(1).nextInt(100, 999)
    }
}

fun demo(strs: Source<String>) {
    val objects: Source<Any> = strs // This is fine, because T is an out-parameter
    println(objects.nextT())
}

/**
 * Kotlin also has a variant note: in. It makes a type parameter contradictory: it can only be consumed but not produced.
 * */
interface Comparable<in T> {
    operator fun compareTo(other: T): Int
}

fun demo(x: Comparable<Number>) {
    x.compareTo(1.0) // 1.0 has type Double, which is a subtype of Number
    // Therefore, we can assign x to a variable of type Comparable <Double>
    val y: Comparable<Double> = x // OK!
}


object Generics {

    @JvmStatic
    fun main(args: Array<String>) {
        demo(Origin())
    }
}