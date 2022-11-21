package org.masingerzero.modernjava.chapter08;

import com.sun.source.tree.NewArrayTree;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.masingerzero.modernjava.model.DataHelper;
import org.masingerzero.modernjava.model.Transaction;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.entry;
import static org.junit.jupiter.api.Assertions.*;

class Chapter08SandBoxTest {

    @Test
    public void test() {
//        Quiz 8.2
//        Figure out what the following code does, and think of what idiomatic operation you
//        could use to simplify what it’s doing:

//        Map<String, Integer> movies = new HashMap<>();
//        movies.put("JamesBond", 20);
//        movies.put("Matrix", 15);
//        movies.put("Harry Potter", 5);
//        Iterator<Map.Entry<String, Integer>> iterator =
//                movies.entrySet().iterator();
//        while(iterator.hasNext()) {
//            Map.Entry<String, Integer> entry = iterator.next();
//            if(entry.getValue() < 10) {
//                iterator.remove();
//            }
//        } //  {Matrix=15, JamesBond=20}
//        System.out.println(movies);


        ConcurrentHashMap<String, Long> concurrentMap = new ConcurrentHashMap<>();
        LongStream.rangeClosed(0, 1_000_000)
                .forEach(value -> concurrentMap.put(String.valueOf(value), value));

        Optional<Long> aLong = Optional.ofNullable(concurrentMap.reduceValues(1, Long::max));
        aLong.ifPresent(System.out::println);


    }


}

