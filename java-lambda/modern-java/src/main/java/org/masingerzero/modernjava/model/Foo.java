package org.masingerzero.modernjava.model;

public class Foo {
    String foo;
    String bar;
    String baz;

    public Foo(String foo, String bar, String baz) {
        this.foo = foo;
        this.bar = bar;
        this.baz = baz;
        System.out.println(foo + " " + bar + " " + baz);
    }
}
