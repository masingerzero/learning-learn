package org.masingerzero.modernjava.chapter6;


import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.IntStream;

class TestSandBox06 {
    public static void main(String[] args) {
//        List<Integer> primes = IntStream.rangeClosed(2, 20)
//                .boxed().collect(new PrimesCollector());
//        System.out.println(primes);

        Map<Boolean, List<Integer>> primes = IntStream.rangeClosed(2, 20)
                .boxed()
                .collect(new PrimesCollectorToMap());
        System.out.println(primes);

    }
}


class Primes {
    public static boolean isPrime(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return primes.stream()
                .takeWhile(i -> i <= candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static boolean isPrimeV8(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return primes.stream()
                .filter(i -> i <= candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static boolean isPrimeV3(List<Integer> primes, int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return takeWhile(primes, integer -> integer <= candidateRoot)
                .stream()
                .noneMatch(integer -> candidate % integer == 0);

    }


//    public Map<Boolean, List<Integer>> partitionPrimes(int n) {
//        return IntStream.rangeClosed(2, n).boxed()
//                .collect(partitioningBy(candidate -> isPrime(candidate));
//    }



    public static <A> List<? extends A> takeWhile(List<? extends A> list, Predicate<? super A> p) {
        int i = 0;

        for (A item : list) {

            if (!p.test(item)) {
                return list.subList(0, i);

            }

            i++;

        }

        return list;

    }


}
//Map<Boolean, List<Integer>>
class PrimesCollector implements Collector<Integer, List<Integer>, List<Integer>> {
    @Override
    public Supplier<List<Integer>> supplier() {
        return ArrayList::new;
    }

    @Override
    public BiConsumer<List<Integer>, Integer> accumulator() {
        return (list, i) -> {
            if (Primes.isPrimeV3(list, i)) {
                list.add(i);
            }
        };
    }

    @Override
    public BinaryOperator<List<Integer>> combiner() {
        return null;
    }

    @Override
    public Function<List<Integer>, List<Integer>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH);
    }
}


class PrimesCollectorToMap implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> {
    @Override
    public Supplier<Map<Boolean, List<Integer>>> supplier() {
        return () -> {
            Map<Boolean, List<Integer>> map = new HashMap<>();
            map.put(true, new ArrayList<>());
            map.put(false, new ArrayList<>());
            return map;
        };
    }

    @Override
    public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
        return (booleanListMap, i) -> booleanListMap.get(Primes.isPrime(booleanListMap.get(true), i)).add(i);
    }

    @Override
    public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {

        return (map1, map2) -> {
            map1.putAll(map2);
            return map1;
        };
    }

    @Override
    public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
        return Function.identity();
    }

    @Override
    public Set<Characteristics> characteristics() {
        return Set.of(Characteristics.IDENTITY_FINISH);
    }
}