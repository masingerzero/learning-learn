package org.masingerzero.modernjava.chapter6;

public class TypeInference {
    static class Value<T> {
    }

    @FunctionalInterface
    interface Bar<T> {
        T apply(Value<T> value); // Change here resolves error
    }

    static class Foo {
        public static <T> T foo(Bar<T> callback) {
            Value<T> value = new Value<>();
            T t = callback.apply(value);
            return t;
        }
    }

    void test() {
//        Foo.foo(value -> true).booleanValue(); // Compile error here
    }




}


