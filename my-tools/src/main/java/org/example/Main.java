package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.TemporalUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        double actualPage = 122;
        double finalPage = 226;
        double remainingPages = finalPage - actualPage;
        LocalDate today = LocalDate.now();
        LocalDate finalDay = LocalDate.of(2023, Month.APRIL, 1);
        long totalDays = finalDay.toEpochDay() - today.toEpochDay();
        double pagesPerDay = remainingPages / totalDays;
        Stream.iterate(today,localDate -> localDate.isBefore(finalDay) ,  localDate -> localDate.plusDays(1))
                .forEach(localDate -> {
                    int page = (int)(actualPage + (pagesPerDay * (localDate.toEpochDay() - today.toEpochDay())));
                    String result = localDate.toString() + " page " + page;
                    System.out.println(result);

                });



    }
}