package org.masingerzero.modernjava;


import org.masingerzero.modernjava.model.Dish;

import static java.util.stream.Collectors.reducing;

public class Sandbox {


    public static void main(String[] args) {

        Integer collect = Dish.menu.stream()
                .collect(reducing(0, Dish::getCalories, Integer::sum));
        System.out.println(collect);
        

    }

}


