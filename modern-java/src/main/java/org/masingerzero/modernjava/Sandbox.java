package org.masingerzero.modernjava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class Sandbox {

    public static void main(String[] args) {
        Function<Integer, ?> function = i -> i.compareTo(3);
        test(function);
        Function<Number, ?> function1 = number -> number.intValue();
        test(function1);
    }

    public static void test(Function<? super Integer, ?> f) {
        Integer integer = 3;
        Object apply = f.apply(integer);
    }

}





