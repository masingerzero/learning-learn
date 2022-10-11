package org.masingerzero.modernjava.chapter6;

import java.util.List;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class FooCollectors {
    public static<T>  MyCollector<T, List<T>, List<T>> toList() {

        return new MyCollector<>() {
            @Override
            public Supplier<List<T>> supplier() {
                return null;
            }

            @Override
            public BiConsumer<List<T>, T> accumulator() {
                return null;
            }

            @Override
            public BinaryOperator<List<T>> combiner() {
                return null;
            }

            @Override
            public Function<List<T>, List<T>> finisher() {
                return null;
            }

            @Override
            public Set<Collector.Characteristics> characteristics() {
                return null;
            }
        };
    }
}
