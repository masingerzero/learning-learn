package org.masingerzero.modernjava.chapter07;

import org.openjdk.jmh.generators.core.Paddings;

import java.util.*;
import java.util.function.Consumer;

public class WordCountSpliterator implements Spliterator<Character> {

    public static Map<String, List<Character>> map = Collections.synchronizedMap(new HashMap<>());
    private final String string;
    private int currentChar = 0;

    public WordCountSpliterator(String string) {
        this.string = string;
    }

    //Similar semantic of iterator getNext until no elements. These are the elements to be processed by the pipeline???
    @Override
    public boolean tryAdvance(Consumer<? super Character> action) {
        String thread = Thread.currentThread().toString();

        if (map.containsKey(thread)) {
            map.get(thread).add(string.charAt(currentChar));
        } else {
            map.put(thread, new ArrayList<>());
            map.get(thread).add(string.charAt(currentChar));
        }

        action.accept(string.charAt(currentChar++));
        if (currentChar == string.length())  {
            System.out.println(map);
        }
        return currentChar < string.length();
    }

    @Override
    public Spliterator<Character> trySplit() {
        int currentSize = string.length() - currentChar;
        if (currentSize < 10) {
            return null;
        }
        for (int splitPos = currentSize / 2 + currentChar; splitPos < string.length(); splitPos++) {
            if (Character.isWhitespace(string.charAt(splitPos))) {
                Spliterator<Character> spliterator = new WordCountSpliterator(string.substring(currentChar, splitPos));
                currentChar = splitPos;
                return spliterator;
            }
        }
        return null;
    }

    @Override
    public long estimateSize() {
        return string.length() - currentChar;
    }

    @Override
    public int characteristics() {
        return ORDERED + SIZED + SUBSIZED + NONNULL + IMMUTABLE;
    }
}
