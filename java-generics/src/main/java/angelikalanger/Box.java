package angelikalanger;

public class Box<T> {
    private T t;

    public Box(T t) {
        this.t = t;
    }

    public void put(T t) {
        this.t = t;
    }

    public T take() {
        return t;
    }

    public boolean equalTo(Box<T> other) {
        return this.t.equals(other.t);
    }

    public Box<T> copy() {
        return new Box<T>(t);
    }

}
