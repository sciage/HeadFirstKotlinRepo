package com.ajiew.headfirstkotlin.chap6Other
/**
 * Operator overloading
 * https://www.kotlincn.net/docs/reference/operator-overloading.html
 * */

data class Point(val x: Int, val y: Int)

/**
 * Functions with overloaded operators need to be marked with operator modifier
 *-The function corresponding to the operator is unaryMinus, so when we overload the operator, the function called by the-operator changes
 * */
operator fun Point.unaryMinus() = Point(-x, -y)

val point = Point(10, 20)

/**
 * Unary operator
 * +a a.unaryPlus()
 * -a a.unaryMinus()
 * !a a.not()
 *
 * Equality and inequality operators
 * a == b a?.equals(b) ?: (b === null)
 * a != b! (a?.equals(b) ?: (b === null))
 *
 * Increasing and decreasing
 * a++ a.inc() + see below
 * a-- a.dec() + see below
 * https://www.kotlincn.net/docs/reference/operator-overloading.html#%E9%80%92%E5%A2%9E%E4%B8%8E%E9%80%92%E5%87% 8F
 *
 * Binary operation
 * a + b a.plus(b)
 * a-b a.minus(b)
 * a * b a.times(b)
 * a / b a.div(b)
 * a% b a.rem(b), a.mod(b) (deprecated)
 * a..b a.rangeTo(b)
 *
 * Comparison operator
 * a> b a.compareTo(b)> 0
 * a <b a.compareTo(b) <0
 * a >= b a.compareTo(b) >= 0
 * a <= b a.compareTo(b) <= 0
 *
 * in operator
 * a in b b.contains(a)
 * a !in b !b.contains(a)
 *
 * Index access operator
 * a[i] a.get(i)
 * a[i, j] a.get(i, j)
 * a[i_1, ……, i_n] a.get(i_1, ……, i_n)
 * a[i] = b a.set(i, b)
 * a[i, j] = b a.set(i, j, b)
 * a[i_1, ……, i_n] = b a.set(i_1, ……, i_n, b)
 *
 * Call operator
 * a() a.invoke()
 * a(i) a.invoke(i)
 * a(i, j) a.invoke(i, j)
 * a(i_1, ……, i_n) a.invoke(i_1, ……, i_n)
 *
 * Generalized assignment
 * a += b a.plusAssign(b)
 * a -= b a.minusAssign(b)
 * a *= b a.timesAssign(b)
 * a /= b a.divAssign(b)
 *
 * Property delegation operator
 * provideDelegate, getValue and setValue operator functions have been described in the delegate properties
 * */
fun main() {
    println(-point)  // Point(x=-10, y=-20)
}