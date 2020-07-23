package com.ajiew.headfirstkotlin.chap2Basics
/**
 * Collection
 * https://www.kotlincn.net/docs/reference/collections.html
 * */
fun main() {
    showList()

    showCoherent()

    listUtilFunctions()

    showSet()

    showMap()

    testCollection()
}

var shapes: List<Shape> = listOf(Rectangle("Desk"))

var mutableShapes: MutableList<Shape> = mutableListOf(Rectangle("Tablet"))

/**
 * Kotlin's List<out T> type is an interface that provides read-only operations, such as size, get, etc.
 * The method to change the list is added by MutableList<T>
 * */
fun showList() {
    println("--------------------------showList-------------------- ------")
    val numbers: MutableList<Int> = mutableListOf(1, 2, 3)
    /* MutableList can be read and written */
    println(numbers)
    numbers[0] = 10
    numbers.clear()

    val readOnlyNumbers: List<Int> = listOf(1, 2, 3) // Implemented with List, List is read-only
    // readOnlyNumbers[2] = 20 // Cannot compile
    // readOnlyNumbers.clear() // cannot compile
    println(readOnlyNumbers)
}

/**
 * Covariance is allowed for List, but MutableList is not
 * */
fun showCoherent() {
    println("--------------------------showCoherent-------------------- ------")
    val circles: List<Circle> = listOf(Circle("Sun"))

    shapes = circles
    println("shapes reassigned: $shapes")

    // This is not allowed for mutable collection types
    // mutableShapes = circles

    // But you can add to it
    mutableShapes.add(Circle("Wheel"))
    println("mutable shapes after add: $mutableShapes")

    /**
     * toList extension method just copies list items
     * */
    mutableShapes.toList()

}

/**
 * List has many useful extension methods to be familiar with
 * */
fun listUtilFunctions() {
    println("--------------------------listUtilFunctions-------------------- ------")
    /**
     * Get a snapshot, toList just copies the list items, so the returned list is guaranteed to never change
     * */
    mutableShapes.toList()

    shapes.firstOrNull()

    shapes.lastIndex

    shapes.last()

    shapes.subList(0, 1)

    shapes.requireNoNulls() // Get all non-empty elements

    if (shapes.none {it.name == "Moon" }) println("No Moon Shape")

    println(shapes[0])
    println(shapes.get(0))
    println(shapes.component1()) // are all Circle(Sun)
}

/**
 * set examples of some common methods
 * */
fun showSet() {
    println("--------------------------showSet-------------------- ------")
    val set = setOf(11, 22, 11, 24)

    println(set)

    println(set.min())

    set.minus(set.min()) // Get a new set except the minimum

    set.plus(33) // opposite to minus
}

/**
 * map examples of some common methods
 * */
fun showMap() {
    println("--------------------------showMap-------------------- ------")
    val map = mapOf("one" to 1, "two" to 2, "three" to 3, 4 to "four")

    println("map[4] = ${map[4]}")

    /**
     * Destructuring assignment
     * */
    for ((key, value) in map) {
        println("map[$key] = $value")
    }
}

fun testCollection() {
    println("--------------------------testCollection--------------------------")
    val firstShape = shapes[0]
    println("firstShape: $firstShape")

    val last = shapes.last()
    println("shapes.lastIndex = ${shapes.lastIndex}, last = $last")

    val subList = shapes.subList(0, shapes.size)
    println("subList: $subList")

    for (shape in shapes) {
        println(shape)
    }
}

open class Shape(val name: String) {
    override fun toString(): String {
        return this.javaClass.simpleName + "($name)"
    }
}

class Rectangle(name: String) : Shape(name) {
    init {
        println("init Rectangle -> $name")
    }
}

class Circle(name: String) : Shape(name) {
    init {
        println("init Circle -> $name")
    }
}
