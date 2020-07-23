package com.ajiew.headfirstkotlin.chap3ClassAndObject
/**
 * Sealed
 * https://www.kotlincn.net/docs/reference/sealed-classes.html
 * */

/**
 * Sealed classes are used to express restricted class inheritance structure: when a value is a type in a limited set, and there can be no other types.
 *
 * In a sense, they are an extension of the enumeration class: the value set of the enumeration type is also limited, but there is only one instance of each enumeration constant, and a subclass of the sealed class can contain state Multiple instances.
 *
 * All subclasses of the sealed class must be written in the same file
 * */
sealed class Expr

data class Const(val number: Double): Expr()

data class Sum(val e1: Expr, val e2: Expr): Expr()

object NotANumber: Expr() {

    fun eval(expr: Expr): Double = when (expr) {
        is Const -> expr.number
        is Sum -> eval(expr.e1) + eval(expr.e2)
        NotANumber -> Double.NaN // commenting out one of the above will cause the need to else
        // The `else` clause is no longer needed, because we have covered all cases
        else -> 0.0 // no need
    }
    @JvmStatic
    fun main(args: Array<String>) {
    }
}