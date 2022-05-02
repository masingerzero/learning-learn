package org.masingerzero;

public interface MyList<E> extends MyCollection<E> {
    public void addAll(MyCollection<? extends E> c);

}
