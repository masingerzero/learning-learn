package org.masingerzero.modernjava;

import org.masingerzero.modernjava.model.DataHelper;
import org.masingerzero.modernjava.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Sandbox {

    public static void main(String[] args) {

        List<Person> adultPersons = filterPersons(DataHelper.getPersons(), Sandbox::isAdult);

        List<Person> persons = DataHelper.getPersons();
        List<Person> personList = persons.stream()
                .filter(person -> person.getAge() > 10)
                .collect(Collectors.toList());
        //The parallel version
        persons.parallelStream()
                .filter(person -> person.getAge() > 10)
                .collect(Collectors.toList());

        System.out.println(adultPersons);

    }

    interface Predicate<T> {
        public boolean test(T t);
    }

    public static List<Person> filterPersons(List<Person> persons, Predicate<Person> t) {
        List<Person> personList = DataHelper.getPersons();
        List<Person> result = new ArrayList<>();
        for (Person person :
                personList) {
            if (t.test(person)) {
                result.add(person);
            }
        }
        return result;
    }

    public static boolean isAdult(Person person) {
        return person.getAge() >= 18;
    }

}
