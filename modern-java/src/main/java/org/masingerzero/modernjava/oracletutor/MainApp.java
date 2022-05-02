package org.masingerzero.modernjava.oracletutor;

import org.masingerzero.modernjava.model.Person;

import java.util.Arrays;
import java.util.List;

import static java.time.LocalDate.of;
import static java.time.Month.*;
import static org.masingerzero.modernjava.model.Person.Sex.MALE;

public class MainApp {

    public static void main(String[] args) {

        List<Person> roster = Arrays.asList(new Person("Charly", of(1950, APRIL, 12), MALE, "coco@gmail.es"),
                new Person("Carl", of(1965, JANUARY, 21), MALE, "carl@gmail.es"),
                new Person("Elma", of(1990, AUGUST, 11), Person.Sex.FEMALE, "elma@gmail.es"),
                new Person("Mary", of(2000, APRIL, 1), Person.Sex.FEMALE, "mary@gmail.es"),
                new Person("Luisa", of(2005, APRIL, 17), Person.Sex.FEMALE, "luisa@gmail.es"),
                new Person("Lolo", of(2001, SEPTEMBER, 20), MALE, "lolo@gmail.es"));

        // Approach 1
        PersonManager.printPersonsOlderThan(roster, 25);
        System.out.println("----------------------------------------------------------------------------------------");

        // Approach 2
        PersonManager.printPersonsWithinAgeRange(roster, 15, 35);
        System.out.println("----------------------------------------------------------------------------------------");

        // Approach 3
        PersonManager.printPersons(roster, new CheckPersonEligibleForSelectiveService());
        System.out.println("----------------------------------------------------------------------------------------");

        // Approach 4
        PersonManager.printPersons(roster, new CheckPerson() {
            @Override
            public boolean test(Person p) {
                return p.getGender() == MALE && p.getAge() >= 18 && p.getAge() <= 25;
            }
        });
        System.out.println("----------------------------------------------------------------------------------------");

        // Approach 5
        PersonManager.printPersons(roster,
                (Person p) -> p.getGender() == MALE && p.getAge() >= 18 && p.getAge() <= 25);
        System.out.println("----------------------------------------------------------------------------------------");

        // Approach 6
        PersonManager.printPersonsWithPredicate(roster,
                p -> p.getGender() == MALE && p.getAge() >= 18 && p.getAge() <= 25);
        System.out.println("----------------------------------------------------------------------------------------");

        // Approach 7
        PersonManager.printPersons(roster,
                p -> p.getGender() == MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                Person::printPerson);

        System.out.println("----------------------------------------------------------------------------------------");

        //Approach 8
        PersonManager.processElements(roster, p -> p.getGender() == MALE
                        && p.getAge() >= 18
                        && p.getAge() <= 25,
                p -> p.getEmailAddress(),
                email -> System.out.println(email));
        System.out.println("----------------------------------------------------------------------------------------");

        //Approach 9
//        roster
//                .stream()
//                .filter();


        // MINE
        PersonManager.printFilteredList(roster, p -> p.getAge() > 50);

    }

}
