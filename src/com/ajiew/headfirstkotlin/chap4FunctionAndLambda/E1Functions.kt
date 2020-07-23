package com.ajiew.headfirstkotlin.chap4FunctionAndLambda

/**
 * Function
 * https://www.kotlincn.net/docs/reference/functions.html
 * */

/**
 * A simple function. The form is as follows:
 * fun method name (parameter name: parameter type): return value type {method body}
 * */
fun double(x: Int): Int {
    return 2 * x
}

/**
 * Function parameters can have default values
 *-The override method always uses the same default parameter values ​​as the base type method
 *-If a default parameter precedes a parameter without a default value, then the default value can only be used by calling the function with named parameters
 * */
fun read(b: Array<Byte>, start: Int = 0, len: Int = b.size-1) {
    for (i in start..len) {
        print("${b[i]}, ")
    }
    println()
}

/**
 * If the last lambda expression parameter is passed from outside the brackets to the function call, then the default parameter is allowed to pass no value
 * */
fun foo(bar: Int = 0, baz: Int = 1, qux: () -> Unit) {
    println("start of foo")
    println("bar = $bar, baz = $baz")
    qux()
    println("end of foo")
}

/**
 * variable parameter
 * */
fun printVararg(vararg strings: String) {
    for (string in strings) {
        print("$string, ")
    }
    println()
}

/**
 * Function that returns Unit
 * In addition, so the function must explicitly specify the return type
 * */
fun returnNothing(name: String?): Unit {
    if (name != null)
        println("Hello ${name}")
    else
        println("Hi there!")
}

/**
 * Single expression function
 * When the function returns a single expression, you can omit the curly braces and specify the code body after the = symbol
 * */
fun double2(x: Int): Int = x * 2

/**
 * Infix notation
 * Functions marked with the infix keyword can also be called using infix notation (ignoring the calling point and parentheses).
 * The infix function must meet the following requirements:
 *-They must be member functions or extension functions;
 *-They must have only one parameter;
 *-Its parameters must not accept a variable number of parameters and cannot have default values.
 * */
infix fun Long.shl(x: Long): Int {
    println("shl $x")
    return 0
}

/**
 * Function scope
 * In Kotlin, functions can be declared at the top level of the file, or in local scope, as member functions and extension functions
 * */
fun demoLocalFun(name: String) {
    val sameSex = false
    // Kotlin supports local functions
    fun filter(age: Int) {
        // Local functions can access local variables of external functions (ie closures) sameSex
        if (age <18 || sameSex) return
        else {
            println("Hi, $name, let's do something dirty:P")
        }
    }
}


class SomeClass() {

    /**
     * Member functions, functions defined within a class or object
     * */
    fun memberFun() {
        println("this is a member function")
    }
}

/**
 * Generic function
 * */
fun <T> singletonList(item: T): List<T> {
    return arrayListOf()
}

/**
 * Inline function
 * */

/**
 * Extension function
 * */

/**
 * Higher-order functions and lambda expressions
 * */

/**
 * Tail recursive function
 * Kotlin supports a functional programming style called tail recursion. This allows some algorithms that are usually written in loops to be written in recursive functions without the risk of stack overflow.
 *-Mark a tail recursive function with the tailrec modifier. To meet the conditions of the tailrec modifier, the function must call itself as the last operation it performs.
 *-When there is more code after the recursive call, tail recursion cannot be used, and it cannot be used in a try/catch/finally block.
 *-Currently tail recursion is only supported in the JVM backend.
 * */
val eps = 1E-10 // "good enough", could be 10^-15

/**
 * Calculate the fixed point of cosine (fixpoint of cosine)
 * */
tailrec fun findFixPoint(x: Double = 1.0): Double =
        if (Math.abs(x-Math.cos(x)) <eps) x
        else findFixPoint(Math.cos(x))


fun main() {
    var result = double(11)
    println(result)

    val bArray = arrayOf('a'.toByte(),'b'.toByte(),'c'.toByte())
    read(bArray) // Parameters with default parameters can be omitted
    read(bArray, 1, 2)

    // Write the function body of the last function directly when calling
    foo {println("do something")}

    // Named parameters: You can use named function parameters when calling functions, which is conducive to enhancing the readability of the code
    foo(bar = 22, baz = 33) {println("do nothing")} // Note: If named parameters are used, only the first named parameter can be omitted

    printVararg("Aaron", "is", "very", "cute")
    // You can also use the asterisk operator (that is, an extended expression) to pass in a variable number of parameters (vararg) in a named form
    printVararg(strings = *arrayOf("a", "b", "c"))
    printVararg("x", "y", "z")

    // The variable parameter list supports the use of extended expressions, and *
    val arr = arrayOf("some", "content")
    printVararg(*arr, "and", "more")

    returnNothing(null)

    var inflix: Int = 1L shl 5L
    // equivalent to this
    1.shl(2)
    println(inflix)

    // call member function
    SomeClass().memberFun()

    println(findFixPoint(22.2))
}