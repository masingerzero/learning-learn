package org.masingerzero;

import java.util.List;

public class Box<E> {
    E e;
    Box<E> subBox;
    public void setElement(E e) {
        this.e = e;
    }

    public E getElement() {
        return e;
    }

    public void setSubBox(Box<? extends E> subBox) {
        this.subBox.setElement(subBox.getElement());
    }

}
