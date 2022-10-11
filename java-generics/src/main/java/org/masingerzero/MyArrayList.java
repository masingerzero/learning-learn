package org.masingerzero;

import java.util.ArrayList;
import java.util.Collection;

class MyArrayList<E> extends ArrayList<E> implements MyList<E> {
    @Override
    public boolean containsElement(E e) {
        boolean containsElement = this.stream()
                .anyMatch(e1 -> e1.equals(e));
        return containsElement;
    }

    @Override
    public boolean containsAllElements(Collection<E> elements) {
        boolean containsAll = this.stream()
                .anyMatch(e -> elements.stream().anyMatch(i -> !i.equals(e)));


        return containsAll;
    }
}
