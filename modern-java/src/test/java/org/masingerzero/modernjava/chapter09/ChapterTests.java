package org.masingerzero.modernjava.chapter09;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

public class ChapterTests {

    @Test
    public void testPoint() {
        Point p1 = new Point(5, 5);
        Point p2 = p1.moveRight(10);
        Assertions.assertAll(
                () -> Assertions.assertEquals(15, p2.getX()),
                () -> Assertions.assertEquals(5, p1.getX())
        );
    }

    @Test
    public void compareTwoPoints() {
        Point p1 = new Point(10, 15);
        Point p2 = new Point(10, 20);

        Assertions.assertTrue(Point.compareByXThenByY.compare(p1, p2) < 0);


    }

    @Test
    public void moveAllPointsToRightByTest() {
        List<Point> points = List.of(new Point(5, 4), new Point(10, 5));
        List<Point> expectedPoints = List.of(new Point(10, 4), new Point(15, 5));

        List<Point> result = Point.moveAllPointsToRightBy(points, 5);
        Assertions.assertEquals(expectedPoints, result, expectedPoints + " != " + result);
    }

    @Test
    public void filterTest() {
        List<Integer> integers = List.of(1,2,3,4,5,6);
        List<Integer> expectedEven = List.of(2,4,6);
        List<Integer> expectedOdds = List.of(1,3,5);

        List<Integer> even = DebugLambda.filter(integers, i -> i % 2 == 0);
        List<Integer> odds = DebugLambda.filter(integers, i -> i % 2 != 0);

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedEven, even),
                () -> Assertions.assertEquals(expectedOdds, odds)

        );


    }

}
