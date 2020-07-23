package com.ajiew.headfirstkotlin.chap6Other

/**
 * Empty safe ?. and ?:
 * https://www.kotlincn.net/docs/reference/null-safety.html
 * */

/**
 * Nullable type and non-empty type
 * */
fun nullSafety() {
    var a: String = "abc"
// a = null // Compilation error, a non-empty string is not allowed to be empty

    /**
     * If you want to allow null, we can declare a variable as a nullable string
     * */
    var b: String? = "abc"
    b = null // ok
    println(b)

    /**
     * If you want to access the same attribute of b, then this is unsafe and the compiler will report an error
     * */
// val l = b.length // variable b may be empty
}

/**
 * Check for null in the condition
 * */
fun checkNull() {
    val c = "Kotlin"
    if (c != null && c.length> 0) {
        println("String of length ${c.length}")
    } else {
        println("Empty string")
    }
}

/**
 * Safe call
 * To call the operator safely, write ?.
 * */
fun safeCall() {
    val a = "Kotlin"
    println(a?.length)

    val b: String? = null // If b is not empty, return b.length, otherwise return null. The type of this expression is Int?
    println(b?.length) // Don't worry about null pointer exception

    /**
     * Safe calls are useful in chain calls
     * */
    // bob?.department?.head?.name // If any attribute (link) is empty, this chain call will return null
}

/**
 * Use with let
 * */
fun safeCallWithLet() {
    val listWithNulls: List<String?> = listOf("Kotlin", null)
    for (item in listWithNulls) {
        item?.let {println(it)} // print A and ignore null
    }
}

/**
 * Elvis operator ?:
 * When we have a nullable reference r, we can say "if r is not null, I use it; otherwise, use some non-null value x"
 * */
fun usingElvis(b: String?) {
    val l = b?.length ?: -1
    println("length is $l")
}

/**
 * !! operator (don't use it!)
 * The non-empty assertion operator (!!) converts any value to a non-empty type, and throws an exception if the value is empty
 * */
fun throwNPE(b: String?) {
    val l = b!!.length
    println("Let's Throw NPE!")
}

/**
 * Safe type conversion
 * If the object is not the target type, then the regular type conversion may cause ClassCastException.
 * Another option is to use a safe type conversion, if the conversion attempt is unsuccessful, it returns null
 * */
fun castSafe(a: Any) {
    val aInt: Int? = a as? Int
    if (aInt != null) println("$aInt was casted to Int")
    else println("cast failed")
}

/**
 * Collection of nullable types
 * If you have a collection of nullable type elements and want to filter non-null elements, you can use filterNotNull to achieve
 * */
fun testFilterNotNull() {
    val nullableList: List<Int?> = listOf(1, 2, null, 4)
    val intList: List<Int> = nullableList.filterNotNull()
    println("not null list: $intList")
}

fun main() {
    nullSafety()

    checkNull()

    safeCall()

    safeCallWithLet()

    usingElvis("what")
    usingElvis(null)

//    throwNPE(null)

    castSafe("11")

    testFilterNotNull()
}