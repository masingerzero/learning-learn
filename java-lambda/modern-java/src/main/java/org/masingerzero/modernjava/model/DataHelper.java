package org.masingerzero.modernjava.model;

import java.util.Arrays;
import java.util.List;

import static java.time.LocalDate.of;
import static java.time.Month.*;
import static org.masingerzero.modernjava.model.Person.Sex.MALE;

public class DataHelper {

    public static List<Person> getPersons() {
        return Arrays.asList(new Person("Charly", of(1950, APRIL, 12), MALE, "coco@gmail.es"),
                new Person("Carl", of(1965, JANUARY, 21), MALE, "carl@gmail.es"),
                new Person("Elma", of(1990, AUGUST, 11), Person.Sex.FEMALE, "elma@gmail.es"),
                new Person("Mary", of(2000, APRIL, 1), Person.Sex.FEMALE, "mary@gmail.es"),
                new Person("Luisa", of(2005, APRIL, 17), Person.Sex.FEMALE, "luisa@gmail.es"),
                new Person("Lolo", of(2001, SEPTEMBER, 20), MALE, "lolo@gmail.es"));
    }

    public static List<Invoice> getInvoices () {
        List<Invoice> inmutableInvoiceList = List.of(
                new Invoice(0001, "orange", 4, 7.0, 28.0),
                new Invoice(0002, "banana", 3, 3.0, 9.0),
                new Invoice(0003, "pear", 5, 4.0, 20.0),
                new Invoice(0004, "apple", 1, 1.0, 1.0),
                new Invoice(0005, "strawberry", 10, 8.0, 80.0),
                new Invoice(0006, "lemon", 2, 6.0, 12.0));

        List<Invoice> mutableInvoices = Arrays.asList(new Invoice(0001, "orange", 4, 7.0, 28.0),
                new Invoice(0002, "banana", 3, 3.0, 9.0),
                new Invoice(0003, "pear", 5, 4.0, 20.0),
                new Invoice(0004, "apple", 1, 1.0, 1.0),
                new Invoice(0005, "strawberry", 10, 8.0, 80.0),
                new Invoice(0006, "lemon", 2, 6.0, 12.0));
        return mutableInvoices;
    }


    public static List<Fruit> getFruits() {
        List<Fruit> fruits = Arrays.asList(
                new Fruit("orange", 15),
                new Fruit("apple", 14),
                new Fruit("banana", 15),
                new Fruit("melon", 9),
                new Fruit("cherry", 6),
                new Fruit("water melon", 6)



        );

        return fruits;
    }



}
