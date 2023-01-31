package org.masingerzero.modernjava.chapter11;

import lombok.Data;

import java.util.Optional;

public class Chapter11SandBox {
    public static void main(String[] args) {
        Person person = new Person();
        Optional<Car> optionalCar = Optional.ofNullable(person)
                .map(Person::getCar)
                .get();

    }

//    public String getInsuranceName(Person person) {
//        return person.getCar().getInsurance().getName();
//    }


    public String getInsuranceName(Person person) {
        return Optional.ofNullable(person)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("No Insurance!!!");
    }


    public static String getInsuranceNameFoo(Person person) {


        String insuranceName = Optional.ofNullable(person)
                .map(Person::getCar)
                .get()
                .map(Car::getInsurance)
                .get()
                .map(Insurance::getName)
                .orElse("No insurance name");


        return insuranceName;
    }


    public static String getInsuranceNameBar(Person person) {

        String insuranceName = Optional.ofNullable(person)
                .map(Person::getCar)
                .map(Optional::get)
                .map(Car::getInsurance)
                .map(Optional::get)
                .map(Insurance::getName)
                .orElse("No insurance name");

        return insuranceName;
    }

}

//@Data
//class Person {
//    private Car car;
//    private Optional<Car> optCar = Optional.empty();
//}
//
//@Data
//class Car {
//    private Insurance insurance;
//    private Optional<Insurance> optInsurance = Optional.empty();
//}


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