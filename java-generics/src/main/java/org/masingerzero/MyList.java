package org.masingerzero;

import java.util.Collection;
import java.util.List;

public interface MyList<E> extends List<E> {
    public boolean containsElement(E e);

    public boolean containsAllElements(Collection<E> elements);
}


