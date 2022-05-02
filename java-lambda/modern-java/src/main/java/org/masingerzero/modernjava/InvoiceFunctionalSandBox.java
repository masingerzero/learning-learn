package org.masingerzero.modernjava;

import org.masingerzero.modernjava.model.DataHelper;
import org.masingerzero.modernjava.model.Person;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static org.masingerzero.modernjava.model.Color.GREEN;
import static org.masingerzero.modernjava.model.Color.RED;

public class InvoiceFunctionalSandBox {

    public static void main(String[] args) {

        List<Person> persons = DataHelper.getPersons();


        Predicate<Person> personsFilter = p -> p.getBirthday().getYear() > 1990;
        personsFilter.
                and(p -> p.getBirthday().getYear() < 2004).
                or(p -> p.getName().equals("Charly"));

        //For it to work you have to do it like this:
        personsFilter = personsFilter.
                and(p -> p.getBirthday().getYear() < 2004).
                or(p -> p.getName().equals("Charly"));

        List<Person> filteredPersons = persons.stream().filter(personsFilter).collect(Collectors.toList());

        filteredPersons.forEach(System.out::println);

        Predicate<Apple> redApple = a -> RED.equals(a.getColor());

        Predicate<Apple> redAndHeavyAppleOrGreen =
                redApple.and(apple -> apple.getWeight() > 150)
                        .or(a -> GREEN.equals(a.getColor()));
//
//        Function<String, Integer> function = s -> s.length();
//        funct
//    ion.andThen()


    }


}

