package org.masingerzero.chapter5.generic;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack<E> implements Stack<E> {
    //size, add and remove on list
    private List<E> list;

    public ArrayStack() {
        list = new ArrayList<>();
    }

    @Override
    public void push(E element) {
        list.add(element);
    }

    @Override
    public E pop() {
        E e = list.remove(list.size() - 1);
        return e;
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
