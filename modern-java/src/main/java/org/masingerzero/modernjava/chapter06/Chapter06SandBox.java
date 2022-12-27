package org.masingerzero.modernjava.chapter06;

import com.sun.source.tree.CompilationUnitTree;
import org.masingerzero.modernjava.model.DataHelper;
import org.masingerzero.modernjava.model.Dish;
import org.masingerzero.modernjava.model.Dish.CaloricLevel;
import org.masingerzero.modernjava.model.Person;

import javax.xml.crypto.Data;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class Chapter06SandBox {
    public static void main(String[] args) {
//        Map<City, Set<String>> namesByCity
//                = DataHelper.getPersons().stream().collect(
//                groupingBy(Person::getCity,
//                        mapping(Person::getLastName,
//                                toSet())));
    }

    private static Map<Dish.Type, Map<CaloricLevel, List<Dish>>> groupDishedByTypeAndCaloricLevel() {
        return Dish.menu.stream().collect(
                groupingBy(dish -> {
                            System.out.println("outer groupBy");
                            return dish.getType();
                        },
                        groupingBy((Dish dish) -> {
                            System.out.println("inner groupBy");
                            if (dish.getCalories() <= 400) {
                                return CaloricLevel.DIET;
                            }
                            else if (dish.getCalories() <= 700) {
                                return CaloricLevel.NORMAL;
                            }
                            else {
                                return CaloricLevel.FAT;
                            }
                        })
                )
        );
    }


}