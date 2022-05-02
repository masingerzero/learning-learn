package org.masingerzero.modernjava;


import org.masingerzero.modernjava.model.Dish;
import org.masingerzero.modernjava.model.Trader;
import org.masingerzero.modernjava.model.Transaction;

import java.util.*;

import static java.util.Arrays.asList;
import static java.util.stream.Collectors.*;
import static org.masingerzero.modernjava.model.Dish.menu;

public class Sandbox {
    enum CaloricLevel { DIET, NORMAL, FAT };

    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        Map<String, List<String>> dishTags = new HashMap<>();
        dishTags.put("pork", asList("greasy", "salty"));
        dishTags.put("beef", asList("salty", "roasted"));
        dishTags.put("chicken", asList("fried", "crisp"));
        dishTags.put("french fries", asList("greasy", "fried"));
        dishTags.put("rice", asList("light", "natural"));
        dishTags.put("season fruit", asList("fresh", "natural"));
        dishTags.put("pizza", asList("tasty", "salty"));
        dishTags.put("prawns", asList("tasty", "roasted"));
        dishTags.put("salmon", asList("delicious", "fresh"));

        Map<Dish.Type, List<String>> collect = menu.stream()
                .collect(groupingBy(Dish::getType, mapping(Dish::getName, toList())));

        Map<Dish.Type, Set<String>> collect1 = menu.stream()
                .collect(groupingBy(Dish::getType, flatMapping(dish -> dishTags.get(dish.getName()).stream(),
                        toSet())));


        Map<Dish.Type, Long> collect2 = menu.stream()
                .collect(groupingBy(Dish::getType, counting()));

        Map<Dish.Type, Optional<Dish>> collect3 = menu.stream()
                .collect(groupingBy(Dish::getType, maxBy(Comparator.comparing(Dish::getCalories))));

        Map<Dish.Type, Dish> collect4 = menu.stream()
                .collect(groupingBy(Dish::getType, collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)),
                        Optional::get)));


        Map<Dish.Type, Integer> collect5 = menu.stream()
                .collect(groupingBy(Dish::getType, summingInt(Dish::getCalories)));
        System.out.println(collect5);


        Map<Dish.Type, Set<CaloricLevel>> collect6 = menu.stream()
                .collect(groupingBy(Dish::getType, mapping(dish -> {
                    if (dish.getCalories() <= 400) return CaloricLevel.DIET;
                    else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
                    else return CaloricLevel.FAT;
                }, toCollection(HashSet::new))));

        System.out.println(collect6);

    }


}


