package de.rieckpil.blog;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MyTestClass {

    @BeforeAll
    void beforeAll() {
        System.out.println("MyTestClass.beforeAll");
    }

    @BeforeEach
    void beforeEach() {
        System.out.println("MyTestClass.beforeEach");
    }

    @Test
    void foo() {
        System.out.println("MyTestClass.foo");
    }

    @Test
    void bar() {
        System.out.println("MyTestClass.bar");
    }

    @Test
    void baz() {
        System.out.println("MyTestClass.baz");
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class InnerClass {
        @BeforeAll
        void beforeAll() {
            System.out.println("InnerClass.beforeAll");
        }

        @BeforeEach
        void beforeEach() {
            System.out.println("InnerClass.beforeEach");
        }

        @Test
        void testOne() {
            System.out.println("InnerClass.testOne");
        }

        @Test
        void tesTwo() {
            System.out.println("InnerClass.tesTwo");
        }

        @Test
        void testThree() {
            System.out.println("InnerClass.testThree");
        }

    }

}
