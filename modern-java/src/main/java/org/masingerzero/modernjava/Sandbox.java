package org.masingerzero.modernjava;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Sandbox {

    public static void main(String[] args) {
        String[] letters = new String[]{"a", "b", "c", "d"};
        Arrays.stream(letters)
                .collect(Collectors.toList());

//        Stream<String> stringStream = Stream.of("");
//        Sandbox.foo(new ArrayList<Integer>());
    }

//    public static <T> void foo(List<T> list) {
//    }


}



