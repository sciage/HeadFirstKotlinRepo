package com.ajiew.headfirstkotlin.chap4FunctionAndLambda
/**
 * Higher-order functions
 * https://www.kotlincn.net/docs/reference/lambdas.html
 * */

/**
 * Higher-order functions are functions that use functions as parameters or return values
 * */
fun <T, R> Collection<T>.fold(
        initial: R,
        combine: (acc: R, nextElement: T) -> R,
        others: String = "default"
): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}

/**
 * Function type
 * Kotlin uses a series of function types similar to (Int) -> String to handle function declarations,
 * These types have a special notation corresponding to the function signature, that is, their parameters and return values:
 *-All function types have a parameter type list enclosed in parentheses and a return type: (A, B) -> C
 *-The function type can have an additional receiver type, which is specified before the point in the notation: type A.(B) -> C
 *-Suspend function is a special kind of function type, and its notation has a suspend modifier, such as suspend () -> Unit or suspend A.(B) -> C
 *-You can also give a function type an alias by using type aliases
 * */
typealias clickHandler = (name: String, event: String) -> Unit

/**
 * Function type instantiation
 * 1. Code blocks using function literals
 *-lambda expression: {a, b -> a + b}
 *-Anonymous function: fun(s: String): Int {return s.toIntOrNull() ?: 0}
 *
 * 2. Use an already declared callable reference
 *-Top-level, partial, member, extension functions: ::isOdd, String::toInt
 *-Top level, members, extended attributes: List<Int>::size
 *-Constructor: ::Regex
 *
 * 3. Use an instance of a custom class that implements a function type interface
 * */
class IntTransformer: (Int) -> Int {
    override operator fun invoke(x: Int): Int = TODO()
}

val intFunction: (Int) -> Int = IntTransformer()

fun main() {
    val items = listOf(1, 2, 3, 4, 5)

    // Lambdas expressions are code blocks enclosed in curly braces
    items.fold(0, {
        // If a lambda expression has parameters, the parameters are preceded by "->"
        acc: Int, i: Int ->

        // Below is the function body
        print("acc = $acc, i = $i, ")
        val result = acc + i
        println("result = $result")
        // The last expression in the lambda expression is the return value:
        result
    }, "void")

    // The parameter type of the lambda expression is optional, if it can be inferred
    // If the last parameter is a Lambda expression, you can write the method outside the parentheses
    val joinedToString = items.fold("Elements:") {acc, i -> "$acc $i"}

    // Function references can also be used for higher-order function calls:
    val product = items.fold(1, Int::times)
    println("joinedToString = $joinedToString")
    println("product = $product")

    val stringPlus: (String, String) -> String = String::plus
}