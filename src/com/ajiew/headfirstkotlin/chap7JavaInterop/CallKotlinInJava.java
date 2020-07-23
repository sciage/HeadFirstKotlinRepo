package com.ajiew.headfirstkotlin.chap7JavaInterop;
/**
 * Call Kotlin in Java
 * https://www.kotlincn.net/docs/reference/java-to-kotlin-interop.html
 * */

/**
 * **Attributes**
 * Kotlin attributes will be compiled into the following Java elements
 *-A getter method, the name is calculated by prefixing get
 *-A setter method whose name is calculated by prefixing set (only applicable to var attributes)
 *-A private field, the same as the attribute name (only applicable to attributes with fields behind the scenes)
 * */
public class CallKotlinInJava {

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Kotlin attributes marked with JvmField can be directly accessed in Java
     * */
    public String getID(Exposed exposed) {
        return exposed.ID;
    }

    public void useFieldInKotlin(Key key1, Key key2) {
        // 1. Fields marked by JvmStatic
        Key.COMPARATOR.compare(key1, key2);

        // 2. A delayed-initialized property in the named object or companion object has a static behind-the-scenes field with the same visibility as the property setter
        Singleton.provider = "";

        // 3. Properties annotated with const (in the class and at the top level) will become static fields in Java
        int VERSION = Key.VERSION;
        int con = Singleton.CONST;
        int max = CallKotlinJvmName.MAX; // After the Kotlin file is compiled, a Java class with the file name as the class name will be generated, and top-level functions, constants, and variables will be placed inside
        String someValue = CallKotlinJvmName.getSomeValue(); // The top-level variables will automatically generate get and set methods
    }
}

