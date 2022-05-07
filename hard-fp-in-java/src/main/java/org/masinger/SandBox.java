package org.masinger;

public class SandBox {

    public static void main(String[] args) {
        add(mult(2, 3), mult(4, 5));
        add(6, 20);
    }


    public static int add(int a, int b) {
        log(String.format("Returning %s as the result of %s + %s", a + b, a, b));
        return a + b;
    }

    public static int mult(int a, int b) {
        return a * b;
    }

    public static void log(String m) {
        System.out.println(m);
    }
}
