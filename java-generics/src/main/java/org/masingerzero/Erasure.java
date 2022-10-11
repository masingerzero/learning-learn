package org.masingerzero;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

class Client {
    public void foo() {
        List<Integer> integers = new ArrayList<>();
        integers.add(0, 1);
        Integer integer = integers.get(0); // Here are a cast
    }
}



class Test {
    public static void main(String[] args) {
        for (Method method : Client.class.getMethods()) {
            System.out.println(method.toString());
        }
    }
}