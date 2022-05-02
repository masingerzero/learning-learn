package org.masingerzero;

import java.util.List;

public class Box<E> {
    E e;
    public void setElement(E e) {
        this.e = e;
    }

    public E getElement() {
        return e;
    }
}
