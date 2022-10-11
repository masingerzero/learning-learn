package org.masingerzero.chapter5.legacyLibWithGenClient.minimalchanges;

public interface Stack<E> {
    void push(E element);
    E pop();
    boolean empty();
}
