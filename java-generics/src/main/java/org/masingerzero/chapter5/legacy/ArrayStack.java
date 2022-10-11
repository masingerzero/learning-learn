package org.masingerzero.chapter5.legacy;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack implements Stack {
    //size, add and remove on list
    private List list;

    public ArrayStack() {
        list = new ArrayList();
    }

    @Override
    public void push(Object element) {
        list.add(element);
    }

    @Override
    public Object pop() {
        Object o = list.remove(list.size() - 1);
        return o;
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
