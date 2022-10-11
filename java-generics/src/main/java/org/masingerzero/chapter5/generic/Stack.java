package org.masingerzero.chapter5.generic;

public interface Stack<E> {
    void push(E element);
    E pop();
    boolean empty();
}
