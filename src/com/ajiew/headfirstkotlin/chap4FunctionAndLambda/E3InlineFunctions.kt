package com.ajiew.headfirstkotlin.chap4FunctionAndLambda

import java.util.concurrent.locks.Lock
/**
 * Inline function
 * https://www.kotlincn.net/docs/reference/inline-functions.html
 * */

/**
 * Problems with higher order functions
 * The use of higher-order functions will bring some runtime efficiency loss: every function is an object, and will capture a closure. That is, the variables that will be accessed in the function body.
 * Memory allocation (for function objects and classes) and virtual calls will introduce runtime overhead.
 * =======
 * Inline function
 * =======
 * The inline modifier affects the function itself and the lambda expression passed to it: all of this will be inlined to the call site.
 * */
inline fun <T> lock(lock: Lock, body: () -> T): T {
    println("do something")
    return body()
}

/**
 * Inlining may increase the generated code;
 * But if we use it properly (that is, avoid inlining too large functions), performance will be improved, especially in the "megamorphic" call in the loop.
 * */