package org.masingerzero.modernjava.model;

import org.masingerzero.modernjava.model.Car.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.LocalDate.of;
import static java.time.Month.*;
import static org.masingerzero.modernjava.model.Car.Color.*;
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
        List<Invoice> invoiceList = List.of(
                new Invoice(0001, "orange", 4, 7.0, 28.0),
                new Invoice(0002, "banana", 3, 3.0, 9.0),
                new Invoice(0003, "pear", 5, 4.0, 20.0),
                new Invoice(0004, "apple", 1, 1.0, 1.0),
                new Invoice(0005, "strawberry", 10, 8.0, 80.0),
                new Invoice(0006, "lemon", 2, 6.0, 12.0));

        return invoiceList;
    }

    public static List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(new Transaction("a12"));
        transactions.add(new Transaction("C14"));
        transactions.add(new Transaction("b13"));
        return transactions;
    }

    public static List<Car> getCars() {
        List<Car> cars = Arrays.asList(new Car("Focus", "Ford", BLACK),
                new Car("Ibiza", "SEAT", ORANGE),
                new Car("Cordoba", "SEAT", ORANGE),
                new Car("Leon", "SEAT", BLUE),
                new Car("Altea", "SEAT", RED),
                new Car("Panda", "SEAT", RED),

                new Car("Mustang", "Ford", RED),
                new Car("Kuga", "Ford", WHITE),
                new Car("Scort", "Ford", WHITE),
                new Car("Focus", "Ford", RED),

                new Car("Rio", "Kia", RED),
                new Car("Forte", "Kia", BLUE),
                new Car("Soul", "Kia", BLACK));

        return cars;
    }





}
