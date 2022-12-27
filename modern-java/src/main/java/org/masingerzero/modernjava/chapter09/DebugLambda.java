package org.masingerzero.modernjava.chapter09;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class DebugLambda {
    public static void main(String[] args) {

        //Create an stream of numbers


    }

    private static int divideByZero(Integer integer) {
        return integer / 0;
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        return list.stream().filter(p).collect(toList());
    }
}

@Getter
@AllArgsConstructor
@ToString
@EqualsAndHashCode
class Point {
    private final int x;
    private final int y;

    public static Comparator<Point> compareByXThenByY = Comparator.comparing(Point::getX).thenComparing(Point::getY);

    public Point moveRight(int x) {
        return new Point(this.x + x, y);
    }

    public static List<Point> moveAllPointsToRightBy(List<Point> points, int x) {
        return points.stream().map(point -> new Point(point.getX() + x, point.getY())).collect(toList());
    }
}