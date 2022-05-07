package org.masingerzero;

import java.util.*;
import java.util.function.Predicate;

public class SandBox {
    public static void main(String[] args) {
//        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//        long totalOdds = count(integers, integer -> (integer % 2) != 0);
//        System.out.println(totalOdds);
//
//        String[] array = {"Hello", "World"};
//        String[] strings = exchangeArray(array, 0, 1);
//        System.out.println(Arrays.toString(strings));

//        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

//        orderList(integers);
//        List<Integer> orderSubList = orderSubList(integers, 0, 4);
//        List<Integer> orderSubList = orderSubListReversed(integers, 0, 4);
//        Integer maximal = findMaximalInRange(integers, 0, 4);
//        System.out.println(maximal);
          FooList<String> list = new FooList<>();
          FooList.cons(42, FooList.nil());
    }


    //<T extends Comparable<? super T>>
//    Comparator<? super E> c

    public static <T> long count(Collection<T> collection, Predicate<T> predicate) {
        long count = collection.stream()
                .filter(predicate)
                .count();
        return count;
    }

    public static <T extends Comparable<T>> List<T> orderList(List<T> list) {
        list.sort((o1, o2) -> o1.compareTo(o2));


        return list;
    }

    public static <T extends Comparable<T>> T findMaximalInRange(List<T> list, int begin, int end) {
        List<T> subList = list.subList(begin, end);
        Comparator<T> comparator = (o1, o2) -> o1.compareTo(o2);
        comparator = comparator.reversed();
        subList.sort(comparator);
        T maximal = subList.get(0);

        return maximal;
    }

    public static <T extends Comparable<T>> List<T> orderSubListReversed(List<T> list, int from, int to) {
        List<T> subList = list.subList(from, to);
        System.out.println("sublist = " + subList);
        Comparator<T> comparator = (o1, o2) -> o1.compareTo(o2);
        comparator = comparator.reversed();
        subList.sort(comparator);


        return subList;
    }


    public static <T extends Comparable<T>> List<T> orderSubList(List<T> list, int from, int to) {
        List<T> subList = list.subList(from, to);
        System.out.println("sublist = " + subList);
        subList.sort((o1, o2) -> o1.compareTo(o2));


        return subList;
    }

    public static <T> T[] exchangeArray(T[] array, int positionX, int positionY) {
        T temp;
        temp = array[positionX];
        array[positionX] = array[positionY];
        array[positionY] = temp;
        return array;
    }

    public static int findMaximalInRange01(List<Integer> list, int from, int to) {
        List<Integer> subList = list.subList(from, to);
        System.out.println(subList);
        Comparator<Integer> comparator = Integer::compareTo;
        comparator = comparator.reversed();
        subList.sort(comparator);
        System.out.println(subList);
        Integer maximal = subList.get(0);
        return maximal;
    }

    public static <T> int findMaximalInRange02(List<Integer> list, int from, int to) {
        List<Integer> subList = list.subList(from, to);
        System.out.println(subList);
        Comparator<Integer> comparator = Integer::compareTo;
        comparator = comparator.reversed();
        subList.sort(comparator);
        System.out.println(subList);
        Integer maximal = subList.get(0);
        return maximal;
    }


}
