package com.ajiew.headfirstkotlin.chap6Other
/**
 * Comment
 * https://www.kotlincn.net/docs/reference/annotations.html
 * */

/**
 * Annotation is a method of attaching metadata to the code, using annotation to declare the annotation class
 *
 * Additional attributes of annotations can be specified by marking the annotation class with meta annotations:
 *-@Target specifies the possible types of elements that can be annotated with this annotation (class, function, attribute, expression, etc.)
 *-@Retention specifies whether the annotation is stored in the compiled class file, and whether it is visible through reflection at runtime (the default is true)
 *-@Repeatable allows the same annotation to be used multiple times on a single element
 *-@MustBeDocumented specifies that the annotation is part of the public API and should be included in the signature of the class or method shown in the generated API document
 * */
@Target(AnnotationTarget.CLASS, // class
        AnnotationTarget.FUNCTION, // function
        AnnotationTarget.VALUE_PARAMETER, // parameter
        AnnotationTarget.FIELD, // attribute
        AnnotationTarget.PROPERTY_GETTER, // Getter
        AnnotationTarget.CONSTRUCTOR) // Constructor
@Retention(AnnotationRetention.SOURCE)
@MustBeDocumented
annotation class Fancy

/**
 * Annotations can have parameters
 *
 * The allowed parameter types are:
 *-Types corresponding to Java primitive types (Int, Long, etc.);
 *-String;
 *-Class (Foo::class);
 *-Enumeration;
 *-Other notes;
 *-The array of the types listed above.
 * */
annotation class Special(val why: String)

/**
 * Usage
 * */
@Fancy
class Foo {
    @Fancy
    fun baz(@Fancy foo: Int): Int {
        return 1
    }
}

/**
 * Comments on the constructor
 * */
//class Foo @Inject constructor(dependency: MyDependency) {……}

/**
 * Annotations can also be used on Lambda expressions
 * */
val f = @Fancy {println("whatever")}

/**
 * Annotation target use
 * When annotating attributes or main constructor parameters, there will be multiple Java elements generated from the corresponding Kotlin elements,
 * So there are multiple possible positions for this annotation in the generated Java bytecode.
 *
 * The complete list of supported usage targets is:
 *-file;
 *-property (annotations with this target are not visible to Java);
 *-field;
 *-get (attribute getter);
 *-set (attribute setter);
 *-receiver (receiver parameter of extension function or property);
 *-param (constructor parameter);
 *-setparam (property setter parameter);
 *-delegate (the field that stores its delegate instance for the delegate property)
 * */
class Example(@field:Fancy val foo: String, // Annotate Java fields
              @get:Fancy val bar: String, // Annotate Java getter
              @param:Fancy val quux: String) // Annotate Java constructor parameters
fun main() {
    Foo().baz(22)
}