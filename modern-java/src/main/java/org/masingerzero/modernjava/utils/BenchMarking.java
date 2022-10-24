package org.masingerzero.modernjava.utils;

import java.util.function.Consumer;

public class BenchMarking {

  public static void main(String[] args) {
//    System.out.println("Partitioning done in: " + execute(PartitionPrimeNumbers::partitionPrimes) + " msecs");
    //System.out.println("Partitioning done in: " + execute(PartitionPrimeNumbers::partitionPrimesWithCustomCollector) + " msecs");
//    execute()
  }

  public static long execute(Consumer<Integer> execute) {
    long fastest = Long.MAX_VALUE;
    for (int i = 0; i < 10; i++) {
      long start = System.nanoTime();
      execute.accept(100_000_000);
      long duration = (System.nanoTime() - start) / 1_000_000;
      if (duration < fastest) {
        fastest = duration;
      }
      System.out.println("done in " + duration);
    }
    return fastest;
  }

}
