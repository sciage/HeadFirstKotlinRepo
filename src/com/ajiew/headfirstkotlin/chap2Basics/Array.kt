package com.ajiew.headfirstkotlin.chap2Basics

/**
 * Array can call the methods in kotlin.collections in addition to the following methods
 * */
fun main() {
    testArray()
}

fun testArray() {
    val names = arrayOf("Maeve", "Carol", "Shelley")

    // Not only subscripts can be used
    println("Second is ${names[1]}")

    // You can also use get set
    names.set(0, "Monica")
    println("First is ${names.get(0)}")

    println("names array size is ${names.size}")

    val plusElement = names.plusElement("Rachel")
    println("plusElement: ${plusElement.toList()}")
    val plus = plusElement.plus(arrayOf("Aaron", "Kevin")) // You can also add Collection
    println("plus: ${plus.toList()}")

    // From the second to the last (fromIndex and toIndex are not included), fill with null
    plusElement.fill("null", 1, plusElement.size)
    println("filled: ${plusElement.toList()}")

    // reverse
    names.reverse()
    println("names are reversed: ${names.toList()}")
    val reversedArray = names.reversedArray()
    println("reversedArray: ${reversedArray.toList()}")
    val reversed = names.reversed() // method in kotlin.collections, converted to reversed List
    println("reversed: $reversed")

    // sort
    val sortedArray = names.sortedArray()
    println("sortedArray: ${sortedArray.toList()}")
    val sortedArrayDescending = names.sortedArrayDescending()
    println("sortedArrayDescending: ${sortedArrayDescending.toList()}")
    val sorted: Any = names.sorted()
    println("sorted: $sorted") // method in kotlin.collections, converted to a sorted List

    // copy
    val copy = names.copyOf()
    val copyOfRange = names.copyOfRange(0, names.size)
    println("copyOfRange: ${copyOfRange.toList()}")

    // slice
    val sliceArray = copy.sliceArray(1 until copy.size)
    println("sliceArray: ${sliceArray.toList()}")
}