package org.masingerzero.modernjava.chapter11;

import lombok.Data;

import java.util.Optional;

public class Chapter11SandBox {
    public static void main(String[] args) {
        Person person = new Person();
        String insuranceName = getInsuranceName(person);
        System.out.println(insuranceName);


    }

    private static String getInsuranceName(Person person) {
        String name = "NO-INSURANCE";
        String name = person.getOptionalCar().orElse(new Car()).getOptionalInsurance().orElse(new Insurance()).getName();
        person.getOptionalCar().orElse(new Car()).getOptionalInsurance().ifPresent();
        String name1 =
        return name;

    }
}

@Data
class Person {
    private Car car;
    private Optional<Car> optionalCar = Optional.empty();
}

@Data
class Car {
    private Insurance insurance;
    private Optional<Insurance> optionalInsurance = Optional.empty();
}

@Data
class Insurance {
    private String name;
}