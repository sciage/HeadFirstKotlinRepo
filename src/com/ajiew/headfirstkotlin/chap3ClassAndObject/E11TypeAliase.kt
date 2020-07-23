package com.ajiew.headfirstkotlin.chap3ClassAndObject

import java.io.File
/**
 * Type alias
 * https://www.kotlincn.net/docs/reference/type-aliases.html
 * */

/**
 * Type aliases provide alternative names for existing types.
 * If the type name is too long, you can introduce a shorter name and use the new name to replace the original type name.
 * It helps to shorten longer generic types, such as reducing collection types
 * */
typealias FileTable<K> = MutableMap<K, MutableList<File>>


/**
 * You can also provide aliases for function types
 * */
typealias MyHandler = (Int, String, Any) -> Unit

class AA {
    inner class Inner
}

/**
 * Create new names for inner and nested classes
 * */
typealias AInner = AA.Inner

fun main() {
    val f: FileTable<String> = mutableMapOf("Key" to mutableListOf(File("Key.file")))
    println(f)
}


