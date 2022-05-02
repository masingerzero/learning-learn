package org.masingerzero;

class Pair<X, Y> {
    X first;
    Y second;

    public Pair() {}
    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public X getFirst() {
        return first;
    }

    public void setFirst(X first) {
        this.first = first;
    }

    public Y getSecond() {
        return second;
    }

    public void setSecond(Y second) {
        this.second = second;
    }

    public void printPair(Pair<X, Y> pair) {
        System.out.println(pair);
    }

    public void printAnotherPair(Pair<?, ?> another) {
        System.out.println("first:" + another.getFirst());
        System.out.println("second:" + another.getSecond());
        System.out.println(another.toString());
    }

    @Override
    public String toString() {
        return "Pair{" +
                "first=" + first.getClass() +
                ", second=" + second.getClass() +
                '}';
    }
}
