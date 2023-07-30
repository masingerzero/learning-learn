package de.rieckpil.blog;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class TestClass {

    int integer = 3;
    public TestClass() {
        System.out.println("TestClass.TestClass");
    }
    @Test
    void foo() {
        integer++;
    }

    @Nested
    class NestedTest {
        @Test
        void foo() {
            System.out.println(integer);
        }
    }

    @Test
    void bar() {

    }


    @Test
    void baz() {

    }

    @Nested
    class AnotherNestedClass {
        @Test
        void bar() {

        }
    }
}
