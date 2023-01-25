package org.masingerzero.modernjava.chapter11;

import lombok.Data;

import java.util.Optional;

public class Chapter11SandBox {
    public static void main(String[] args) {



    }

//    public String getInsuranceName(Person person) {
//        return person.getCar().getInsurance().getName();
//    }
    public String getInsuranceName(Person person) {
        return Optional.ofNullable(person)
                .map(Person::getCar)
                .map(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("No Insurance!!!");
    }



}

@Data
class Person {
    private Car car;
    private Optional<Car> optCar = Optional.empty();
}

@Data
class Car {
    private Insurance insurance;
    private Optional<Insurance> optInsurance = Optional.empty();
}

@Data
class Insurance {
    private String name;
}