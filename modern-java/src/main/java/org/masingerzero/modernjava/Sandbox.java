package org.masingerzero.modernjava;

import java.util.*;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sandbox {

    public static void main(String[] args) {
        Supplier<Map<Boolean, List<Integer>>> supplier = () -> new HashMap<>() {{
            put(true, new ArrayList<>());
            put(false, new ArrayList<>());
        }};

        List<Integer> integers = new ArrayList<>() {{
            add(1);
            add(2);
        }};





    }

    public static void testWildcardPredicate (Predicate<? super Integer> predicate) {
        Integer i = 1;
        predicate.test(i);
    }

    public static<T> void testPredicate(Predicate<? super T> p, T t) {
        p.test(t);
    }

}



