package com.ajiew.headfirstkotlin.chap4FunctionAndLambda
/**
 * Lambda expression
 * https://www.kotlincn.net/docs/reference/lambdas.html
 * */

/**
 * Lambda expressions are always enclosed in curly braces, parameter declarations in the complete syntax form are placed in curly braces, with optional type annotations, and the function body follows a -> symbol.
 * If the inferred return type of the lambda is not Unit, then the last (or possibly a single) expression in the body of the lambda will be regarded as the return value.
 * */
val sum = {x: Int, y: Int -> x + y}

/**
 * Complete Lambda expression
 * */
val fullSum: (Int, Int) -> Int = {x, y -> x + y}

/**
 * it: the implicit name of a single parameter
 * If the compiler can recognize the signature itself, you can also ignore the unique parameter and ignore ->. This parameter is implicitly declared as it:
 * */
fun showIt() {
    val ints = arrayOf(-1, 2, 3)
    var result = ints.filter { it > 0 }
    println(result)
}

fun main() {
    showIt()
}