package org.masingerzero.chapter5.legacyLibWithGenClient.minimalchanges;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack<E> implements Stack<E> {
    //size, add and remove on list
    private List list;

    public ArrayStack() {
        list = new ArrayList();
    }

    @Override
    public void push(E element) {
        list.add(element);
    }

    @Override
//    @SuppressWarnings("unchecked")
    public E pop() {
        Object o = list.remove(list.size() - 1);
        return (E)o;
    }

    @Override
    public boolean empty() {
        return list.size() == 0;
    }

    @Override
    public String toString() {
        return "stack"+list.toString();
    }
}
