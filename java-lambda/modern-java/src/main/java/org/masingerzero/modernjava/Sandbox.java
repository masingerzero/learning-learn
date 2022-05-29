package org.masingerzero.modernjava;


import org.masingerzero.modernjava.model.Dish;

import java.util.List;
import java.util.stream.Collectors;

public class Sandbox {
    public static void main(String[] args) {
        List<Dish> dish = Dish.menu.stream()
                .collect(new ToListCollector<>());
        System.out.println(dish);

        Dish.menu.stream()
                .collect(Collectors.toList());

    }
}


