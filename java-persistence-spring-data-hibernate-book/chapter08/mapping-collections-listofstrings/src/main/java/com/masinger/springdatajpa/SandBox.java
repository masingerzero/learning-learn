package com.masinger.springdatajpa;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SandBox {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");

        System.out.println(stringList);

        stringList.add(1, "four");
        System.out.println(stringList);

        stringList.set(1, "five");

        System.out.println(stringList);


        System.out.println(stringList);
    }
}
