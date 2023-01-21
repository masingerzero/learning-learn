package org.masingerzero.modernjava.chapter11;

import lombok.Data;

import java.util.Optional;

public class Chapter11SandBox {
    public static void main(String[] args) {


        Person person = new Person();
        Optional<Person> optPerson = Optional.of(person);
        Optional<String> s = optPerson.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName);
    }


}

@Data
class Person {

    private Optional<Car> car = Optional.empty();
}

@Data
class Car {

    private Optional<Insurance> insurance = Optional.empty();
}

@Data
class Insurance {
    private String name;
}