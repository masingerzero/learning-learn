package org.masingerzero.modernjava;


import org.masingerzero.modernjava.model.Dish;

import java.util.stream.Collectors;

public class Sandbox {
    enum CaloricLevel { DIET, NORMAL, FAT };

    public static void main(String[] args) {

        Long totalDishes;
        totalDishes = Dish.menu.stream()
                .collect(Collectors.counting());


    }

}


