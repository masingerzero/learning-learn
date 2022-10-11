package org.masingerzero.modernjava.chapter6;


import org.w3c.dom.css.ElementCSSInlineStyle;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class TestMain06 {
    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1,3,5);
        List<Integer> collect = integers.stream()
                .collect(new ListCollector<>());
//        System.out.println(collect);
        System.out.println(collect.hashCode());
//        List<String> collect = Streams.getStream("")
//                .collect(FooCollectors.toList());
    }
}

interface MyStream<T> {
    <R, A> R collect(MyCollector<? super T, A, R> collector);
}

class ListCollector<T> implements Collector<T, List<T>, List<T>> {

    @Override
    public Supplier<List<T>> supplier() {
        return () -> {
            ArrayList<T> arrayList = new ArrayList<>();

            return arrayList;
        };
    }

    @Override
    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    @Override
    public BinaryOperator combiner() {
        return null;
    }

    @Override
    public Function<List<T>, List<T>> finisher() {
        return ts -> {
            return ts;
        };
    }

    @Override
    public Set<Characteristics> characteristics() {
        return new HashSet<>();
    }
}


interface MyCollector<T, A, R> {

    /**
     * A function that creates and returns a new mutable result container.
     *
     * @return a function which returns a new, mutable result container
     */
    Supplier<A> supplier();

    /**
     * A function that folds a value into a mutable result container.
     *
     * @return a function which folds a value into a mutable result container
     */
    BiConsumer<A, T> accumulator();

    /**
     * A function that accepts two partial results and merges them.  The
     * combiner function may fold state from one argument into the other and
     * return that, or may return a new result container.
     *
     * @return a function which combines two partial results into a combined
     * result
     */
    BinaryOperator<A> combiner();

    /**
     * Perform the final transformation from the intermediate accumulation type
     * {@code A} to the final result type {@code R}.
     *
     * <p>If the characteristic {@code IDENTITY_FINISH} is
     * set, this function may be presumed to be an identity transform with an
     * unchecked cast from {@code A} to {@code R}.
     *
     * @return a function which transforms the intermediate result to the final
     * result
     */
    Function<A, R> finisher();

    /**
     * Returns a {@code Set} of {@code Collector.Characteristics} indicating
     * the characteristics of this Collector.  This set should be immutable.
     *
     * @return an immutable set of collector characteristics
     */
    Set<Collector.Characteristics> characteristics();
}

class Streams {
    public static<T> MyStream<T> getStream(T t) {
        return null;
    }
}


