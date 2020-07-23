package com.ajiew.headfirstkotlin.chap3ClassAndObject
/**
 * Attributes and fields
 * https://www.kotlincn.net/docs/reference/properties.html
 * */

/**
 * Compile-time constants, use const val declaration, only basic data types and String are allowed
 * */
const val OS: String = "Mac OS X Mojave 10.14"

/**
 * Declare attributes
 * var <propertyName>[: <PropertyType>] [= <property_initializer>]
 * [<getter>]
 * [<setter>]
 * */
class Property(name: String) {

    /**
     * The backing field is mainly used for properties in the accessor (Getter/Setter), provided that the default accessor is used or the field is explicitly called
     * If an accessor uses the default implementation, then Kotlin will automatically provide behind-the-scenes fields
     * If there is an initializer, there must be a field behind the scenes, and vice versa
     * */
    var size: Int = 0
        set(value) {
            /**
             * To assign values ​​to attributes requires the use of behind-the-scenes fields. Kotlin uses the field keyword to reference behind-the-scenes fields
             * */
            if (value >= 0) field = value
        }

    var isEmpty = true
        get() = this.size == 0
        set(value) {
            println("You have to set \"field\" manually to create a backing field")
            // If you don't manually call field, it will remind you that it is not allowed to initialize properties, because there is no behind-the-scenes field. You can try to comment out the following line:
            field = value

            /*
            * The essence is because Kotlin uses getter setters to access and assign values ​​to properties
            * The getter setter accesses or assigns values ​​through the backing field. If there is no behind-the-scenes field, the assignment will become an endless loop
            * */
            // isEmpty = value // Recursive property accessor
        }

    /**
     * Since it is a read-only val, there is no setter, and the get accessor is rewritten and the field is not referenced, so there is no backing field in this case
     * */
    val noBackingField: Boolean
        get() = this.size == 0
// get() = field // If you return filed directly, you must initialize it because there is a backing field

    /**
     * Backing property
     * External performance is read-only, internal performance is readable and writable, we call this attribute behind the scenes.
     * */
    public val table: Map<String, Int>
        get() {
            if (_table == null) {
                _table = HashMap() // type parameters have been inferred
            }
            return _table ?: throw AssertionError("Set to null by another thread")
        }

    /**
     * The outside can only be accessed through the table, but in fact the access is _table, so we call _table as a behind-the-scenes attribute at this time
     * This is similar to controlling access to class attribute points by setting Getter and Setter in Java
     * */
    private var _table: Map<String, Int>? = null

    /**
     * Delayed initialization, using the keyword lateinit, the usage scenario can be: when using dependency injection or initialization in the setup of unit test
     * */
    lateinit var owner: People

    init {
        // If the property of lateinit is called before initialization, an exception will be thrown
        owner = People("Aaron")
        println("init main Constructor: owner is ${owner.name}")
    }

    fun main() {
        // Determine whether the value is initialized by isInitialized
        if (this::owner.isInitialized) {
        }
    }
}

object PropertyAndField {

    @JvmStatic
    fun main(args: Array<String>) {
        val p = Property("IntelliJ")
        p.size = 2 // Setter will be called

        println(p.isEmpty)

        println("try set isEmpty to true....")
        p.isEmpty = true
        println(p.isEmpty)
    }
}