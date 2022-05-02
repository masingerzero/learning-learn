package org.masingerzero;

import java.util.*;

public class Foo<T extends Collection> {

    T t;
    public Foo() {
    }

    public Foo (String s1, String s2) {}

    public void test(T t) {
        t.forEach(System.out::println);

    }



}
