package org.masingerzero.modernjava.chapter07;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@Fork(value = 2, jvmArgs={"-Xms4G", "-Xmx4G"})
public class ParallelStreamBenchmarks {
    private static final Long N = 10_000_000L;



//    @Benchmark
//avgt   10    3.231 ± 0.028  ms/op
    public long iterativeSum() {
        long result = 0;
        for (long i = 1L; i <= N; i++) {
            result += i;
        }
        return result;
    }

//    @Benchmark
//    avgt   10  100.879 ± 0.785  ms/op
    public long sequentialSum() {
        return Stream.iterate(1L, i -> i + 1)
                .limit(N)
                .reduce(0L, Long::sum);
    }

//    avgt   10  153.531 ± 3.099
//    @Benchmark
    public long parallelSum() {
        return Stream.iterate(1L, i -> i + 1).
                limit(N)
                .parallel()
                .reduce(0L, Long::sum);
    }

    //avgt   10  3.211 ± 0.020  ms/op
//    @Benchmark
    public long rangedSum() {
        return LongStream.rangeClosed(1, N).reduce(0L, Long::sum);
    }

    //avgt   10  0.523 ± 0.012  ms/op
//    @Benchmark
    public long parallelRangedSum()  {
        return LongStream.rangeClosed(1, N)
                .parallel()
                .reduce(0l, Long::sum);
    }
}
