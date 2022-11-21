package org.masingerzero.modernjava.chapter07;


import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

class SpliteratorTest {
    public static void main(String[] args) {
        final String SENTENCE =
                " Nel mezzo del cammin di nostra vita " +
        "mi ritrovai in una selva oscura" +
                " ché la dritta via era        smarrita ";
        int counter = StreamSupport.stream(new WordCountSpliterator(SENTENCE), true)
                .reduce(new WordCounter(0, false), WordCounter::accumulator, WordCounter::combiner)
                .getCounter();
        System.out.println(counter);
//                .forEach(System.out::println);
//        int counter = IntStream.rangeClosed(0, SENTENCE.length() - 1)
//                .mapToObj(SENTENCE::charAt)
//                .parallel()
//                .reduce(new WordCounter(0, false), WordCounter::accumulator, WordCounter::combiner)
//                .getCounter();
//        System.out.println(counter);
//                .forEach(character -> System.out.println(character));

    }



}

class WordCounter {
    private final int counter;
    private final boolean lastSpace;

    public WordCounter(int counter, boolean lastSpace) {
        this.counter = counter;
        this.lastSpace = lastSpace;
    }

    public WordCounter accumulator(char c) {
        if (Character.isWhitespace(c)) {
            return  (lastSpace)
                    ? this
                    : new WordCounter(counter, true);
        } else {
            return (lastSpace)
                    ? new WordCounter(counter + 1, false)
                    : this;
        }

    }

    public int getCounter() {
        return counter;
    }

    public WordCounter combiner(WordCounter wordCounter2) {
        return new WordCounter(counter + wordCounter2.counter, false);
    }

}