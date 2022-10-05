package org.masingerzero.chapter5.genericwithlegacyclient;

public interface Stack<E> {
    void push(E element);
    E pop();
    boolean empty();
}
