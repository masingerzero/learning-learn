package org.masingerzero.modernjava.chapter09;


import org.masingerzero.modernjava.model.Dish;
import org.masingerzero.modernjava.model.ParentDish;

import java.security.Key;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Chapter09 {
    public static void main(String[] args) {
//        Dish.menu.stream()
//                .collect(Collectors.groupingBy(dish -> {
//                    if (dish.getCalories() <= 400) return Dish.CaloricLevel.DIET;
//                    else if (dish.getCalories() <= 700) return Dish.CaloricLevel.NORMAL;
//                    else return Dish.CaloricLevel.FAT;
//                }));

        Dish.menu.stream()
                .collect(Collectors.groupingBy(Dish::getCaloricLevel));
//        Function<ParentDish, String> f1 = parentDish -> "Hello";
//        Dish.menu.stream()
//                .collect(Collectors.groupingBy(f1 ));
//
//        test(f1);
    }

    public static void test(Function<Dish, String> function) {
        Dish dish = new Dish("bacon", false, 2000, Dish.Type.MEAT);
        String apply = function.apply(dish);
        System.out.println(apply);
    }




}


