package org.masingerzero;

public interface MyCollection<E> {
    public void addAll(MyCollection<? extends E> c);
}


