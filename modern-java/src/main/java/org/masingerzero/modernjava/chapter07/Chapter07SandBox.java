package org.masingerzero.modernjava.chapter07;

import org.masingerzero.modernjava.utils.BenchMarking;

import java.util.stream.Stream;

public class Chapter07SandBox {
    public static void main(String[] args) {
        long execute = BenchMarking.execute(Chapter07SandBox::reduceNotParallel);
        System.out.println("done in " + execute + " ms");
        execute = BenchMarking.execute(Chapter07SandBox::reduceParallel);
        System.out.println("done in " + execute + " ms");
    }

    private static void reduceNotParallel(long max_numbers) {
        Stream.iterate(1L, i -> i + 1)
                .limit(max_numbers)
                .reduce(0L, Long::sum);
    }

    private static void reduceParallel(long max_numbers) {
        Stream.iterate(1L, i -> i + 1)
                .limit(max_numbers)
                .parallel()
                .reduce(0L, Long::sum);
    }
}