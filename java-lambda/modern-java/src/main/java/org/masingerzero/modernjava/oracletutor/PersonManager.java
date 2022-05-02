package org.masingerzero.modernjava.oracletutor;

import org.masingerzero.modernjava.model.Person;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class PersonManager {

    // Approach 1
    public static void printPersonsOlderThan(List<Person> roster, int age) {
        for (Person p : roster) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    // Approach 2
    public static void printPersonsWithinAgeRange(List<Person> roster, int low, int high) {
        for (Person p : roster) {
            if (low <= p.getAge() && p.getAge() < high) {
                p.printPerson();
            }
        }
    }

    // Approach 3
    public static void printPersons(List<Person> roster, CheckPerson tester) {
        for (Person person : roster) {
            if (tester.test(person)) {
                person.printPerson();
            }
        }
    }

    public static void printPersonsWithPredicate(List<Person> roster, Predicate<Person> tester) {
        for (Person person : roster) {
            if (tester.test(person)) {
                person.printPerson();
            }
        }
    }

    public static void printPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
        for (Person person : roster) {
            if (tester.test(person)) {
                block.accept(person);
            }
        }
    }

    public static <X, Y> void processElements(Iterable<X> source,
                                              Predicate<X> tester,
                                              Function<X, Y> mapper,
                                              Consumer<Y> block) {
        for (X p : source) {
            if (tester.test(p)) {
                Y data = mapper.apply(p);
                block.accept(data);
            }
        }
    }

    //// MIO
    public static <T> void printFilteredList(List<T> list, Predicate<T> p) {
        for (T e : list) {
            if (p.test(e)) {
                System.out.println(e);
            }
        }
    }

}
