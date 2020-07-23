package com.ajiew.headfirstkotlin.chap3ClassAndObject
/**
 * Enumeration class
 * https://www.kotlincn.net/docs/reference/enum-classes.html
 * */

/**
 * Enumeration constants also implement the Comparable interface, where the natural order is the order they are defined in the enumeration class.
 * */
enum class Direction {
    NORTH, SOUTH, WEST, EAST
}

/**
 * Initialization
 * */
enum class Color(val rgb: Int) {
    RED(0xFF0000),
    GREEN(0x00FF00),
    BLUE(0x0000FF);

    fun printColor() {
        println(rgb)
    }
}

/**
 * Anonymous class
 * */
enum class ProtocolState {
    WAITING {
        override fun signal() = TALKING
    },

    TALKING {
        override fun signal() = WAITING
    };

    abstract fun signal(): ProtocolState
}

object EnumClass {

    @JvmStatic
    fun main(args: Array<String>) {
        val north = Direction.NORTH
        println("name = "+ north.name + ", ordinal =" + north.ordinal)

        val value = Direction.valueOf("WEST")
        println("value of WEST = $value, position = "+ value.ordinal)

        for (v in Direction.values()) {
            println("= $v")
        }

        println(ProtocolState.WAITING.signal())
        println(ProtocolState.TALKING.signal())

        // Enum constant implements the Comparable interface by default, you can use compareTo for comparison, where the order is the defined order
        println(Direction.SOUTH.compareTo(Direction.EAST))
        println(Direction.SOUTH.compareTo(Direction.NORTH))
    }
}