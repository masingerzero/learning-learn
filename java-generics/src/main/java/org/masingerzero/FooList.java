package org.masingerzero;

import java.util.List;

public class FooList<E> {
    E e;

    static <Z> FooList<Z> nil() {  return new FooList<>(); };

    static <Z> FooList<Z> cons(Z head, FooList<Z> tail) { return new FooList<>();  };

    E head() { return e; }


}
