package org.masingerzero;

class X< T > {
    private T t;

    public  T     m() { return t;}
    public  void m( T arg)              {}

    public  Y<T> f() { return new Y<T>(); }

    public  void f(Y< T > arg)           { }

    public  Y<? extends T > f1()         { return new Y<T>();}
    public  void f2(Y<? extends T > arg) { }

    public  Y<? super T > f3()           { return new Y<T>();}
    public  void f4 (Y<? super T > arg)   {}
}

class Y<T> {

}