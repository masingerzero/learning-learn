package org.masingerzero.modernjava.chapter07;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

public class Chapter07SandBox {
    public static void main(String[] args) {
        Long[] array = LongStream.rangeClosed(0, 1000).boxed().toArray(Long[]::new);
        SumArrayTask sumArrayTask = new SumArrayTask(array);
        Long invoke = new ForkJoinPool().invoke(sumArrayTask);

        System.out.println("sumtotal" + "  " + invoke);


        long sum = LongStream.rangeClosed(0, 1000).sum();
        System.out.println(sum);
    }


}


class SumArrayTask extends RecursiveTask<Long> {
    private final Long[] longArray;

    public SumArrayTask(Long[] longArray) {
        this.longArray = longArray;
    }
    @Override
    protected Long compute() {

        if (longArray.length <= 10) {
            return Arrays.stream(longArray)
                    .mapToLong(value -> value.longValue())
                    .sum();
        }

        Long[] leftSplit = LongStream.rangeClosed(0, longArray.length / 2).boxed().toArray(Long[]::new);
        SumArrayTask sumArrayTaskLeft = new SumArrayTask(leftSplit);
        sumArrayTaskLeft.fork();
        Long[] rightSplit = LongStream.rangeClosed((longArray.length / 2) + 1, longArray.length).boxed().toArray(Long[]::new);
        SumArrayTask sumArrayTaskRight = new SumArrayTask(rightSplit);

        return sumArrayTaskRight.compute() + sumArrayTaskLeft.join();
    }

}

