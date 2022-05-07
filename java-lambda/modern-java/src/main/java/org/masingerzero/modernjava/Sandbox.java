package org.masingerzero.modernjava;


import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Sandbox {


    public static void main(String[] args) {
        Map<Boolean, List<Integer>> primesAndNotPrimes = IntStream.rangeClosed(1, 100).boxed()
                .collect(Collectors.partitioningBy(Sandbox::isPrime));
        System.out.println(primesAndNotPrimes);
    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) (Math.sqrt((double) candidate));
        boolean isPrime = IntStream.rangeClosed(2, candidateRoot).noneMatch(i -> candidate % i == 0);
        return isPrime;
    }



}


