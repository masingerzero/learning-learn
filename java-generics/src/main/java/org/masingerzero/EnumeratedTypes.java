package org.masingerzero;

import java.util.Arrays;
import java.util.Optional;

enum TestEnum {
    ONE,
    TWO,
    THREE
}

class TestEnumTypes {
    public static void main(String[] args) {
        assert Season.valueOf("SPRING").equals(Season.SPRING);
        assert Season.FALL.compareTo(Season.WINTER) < 0;
        Season.valueOf("");
    }
}


abstract class Enum<E extends Enum<E>> implements Comparable<E> {

    protected final String name;
    protected final int ordinal;

    protected Enum(String name, int ordinal) {
        this.name = name;
        this.ordinal = ordinal;
    }

//    public static <T extends java.lang.Enum<T>> T valueOf(Class<T> enumType,
//                                                          String name) {
//        T result = null;
//        if (result != null)
//            return result;
//        if (name == null)
//            throw new NullPointerException("Name is null");
//        throw new IllegalArgumentException(
//                "No enum constant " + enumType.getCanonicalName() + "." + name);
//    }
}

class Season extends Enum<Season> {

    public static final Season SPRING = new Season("SPRING", 0);
    public static final Season SUMMER = new Season("SUMMER", 1);
    public static final Season FALL = new Season("FALL", 2);
    public static final Season WINTER = new Season("WINTER", 3);

    private final static Season[] VALUES = {SPRING, SUMMER, FALL, WINTER};

    private Season(String name, int ordinal) {
        super(name, ordinal);
    }

    @Override
    public int compareTo(Season o) {
        return this.ordinal - o.ordinal;
    }

    public static Season[] values() {
        return VALUES.clone();
    }

    public static Season valueOf(String name) {
        return Arrays.stream(VALUES)
                .filter(season -> name.equals(season.name))
                .findFirst()
                .orElseThrow();
    }


}
