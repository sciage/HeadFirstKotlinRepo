package com.ajiew.headfirstkotlin.chap3ClassAndObject

/**
 * Visibility modifier
 * https://www.kotlincn.net/docs/reference/visibility-modifiers.html
 * */

/**
 * =======================================
 * If you do not specify any visibility modifier, **default is public**
 * =======================================
 * */
class Whatever {

    /**
     * Any client that can see the class declaration can see its public members
     * */
    public var visible: String = "public"

    var v2: String = "default is public"

    /**
     * internal can see any client in this module declared by the class can see its internal member
     *
     * Module refers to a set of Kotlin files compiled together:
     *-An IntelliJ IDEA module;
     *-A Maven project;
     *-A Gradle source set;
     *-One set of files compiled by <kotlinc> Ant task execution.
     * */
    internal val half: String = "internal"

    /**
     * protected is the same as private + visible in subclasses
     * *
     * Note:
     *-Not applicable to top-level declarations
     *-If you override a protected member and don't explicitly specify its visibility, the member will still be protected.
     * */
    protected val less: String = "protected"

    /**
     * If you declare it as private, it will only be visible in the file where it is declared
     * *
     * Note:
     *-In Kotlin, external classes cannot access private members of internal classes
     * */
    private val notVisible: Int = 2

}

object VisibilityModifiers {
    @JvmStatic
    fun main(args: Array<String>) {
    }
}