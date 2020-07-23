package com.ajiew.headfirstkotlin.chap6Other
/**
 * Type checking and conversion
 * https://www.kotlincn.net/docs/reference/typecasts.html
 * */

fun testIsAndNot() {
    val obj = "something unknown"

    if (obj is String) {
        println("$obj is string and length is ${obj.length}")
    }

    // or

    if (obj !is String) {// same as !(obj is String)
        println("Not a String")
    } else {
        println("length is "+ obj.length)
    }
}

/**
 * In many cases, there is no need to use explicit conversion operators in Kotlin,
 * Because the compiler tracks is-checks and explicit conversions of immutable values, and automatically inserts (safe) conversions when needed
 * */
fun autoCasting(arg: Any) {


    /**
     * After is checked, it is automatically converted to String, so it can be called directly
     * */
    if (arg is String) println("String length is "+ arg.length)
}

fun moreAutoCasting(x: Any) {

    /**
     * `||` The x on the right is automatically converted to a string, so the call is safe
     * */
    if (x !is String || x.length == 0) return

    /**
     * These smart conversions are the same for when-expression and while-loop
     * */
    when (x) {
        is Int -> print(x + 1)
        is IntArray -> print(x.sum())
    }
}

/**
 * Smart conversion rules for variables
 *-val local variable: always possible, except for local delegated properties;
 *-val attribute: If the attribute is private or internal, or the check is performed in the same module where the attribute is declared. Smart conversion does not apply to open attributes or attributes with custom getters;
 *-var local variable: if the variable is not modified between inspection and use, is not captured in the lambda that will modify it, and is not a local delegated property;
 *-var attribute: never possible (because the variable can be modified by other codes at any time)
 * */
fun showAutoCastingLimit() {
    class Inner {
        private val name = "aaron"
        var age: Any = 25

        fun casting() {
            // The automatic conversion of the val attribute is safe
            if (name is String) println("name length ${name.length}")

            // var attribute is different, because it may be changed at any time
            age = "what"
            if (age is Int) {
                // Cannot be automatically converted to Int
                // println(age.minus(2))
            }

            val localName = "Kevin"
            // Local variables can always be converted automatically
            if (localName is String) println("localName length ${localName.length}")

            var localAge: Any = 25
            localAge = "what"
            if (localAge is Int) {
                println(localAge.plus(2))
            }
        }
    }

    Inner().casting()
}

/**
 * If the conversion is not possible, the conversion operator will throw an exception. Therefore, we call it insecure.
 * Unsafe conversion in Kotlin is done by the infix operator as
 * */
fun notSafeCastingAs(y: Any) {
    val x: String = y as String

    println("Casting success")
}

/**
 * In order to avoid throwing exceptions, you can use the safe conversion operator as?, which can return null on failure
 * */
fun nullableNotSafeCasting(y: Any?) {
    val nullableX: String? = y as? String

    println("Casting success")
}


fun main() {
    testIsAndNot()

    autoCasting("Hello")

    showAutoCastingLimit()

//    notSafeCastingAs(12)

    nullableNotSafeCasting(null)
}