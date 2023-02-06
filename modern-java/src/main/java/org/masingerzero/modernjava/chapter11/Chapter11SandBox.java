package org.masingerzero.modernjava.chapter11;

import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter11SandBox {
    public static void main(String[] args) {
        //



    }

    public static List<String> getInsuranceNames(List<Person> persons) {




    }

    public static Optional<Insurance> nullSafeCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        if (person.isPresent() && car.isPresent()) {
            return Optional.of(findTheCheapestInsurance(person.get(), car.get()));
        } else {
            return Optional.empty();
        }
    }

    public static Insurance findTheCheapestInsurance(Person person, Car car) {
        Insurance insurance = new Insurance();
        insurance.setName("The cheapest insurance is that...");
        return insurance;
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
    private Optional<List<Car>> cars = Optional.empty();
//    private Optional<Car> car = Optional.empty();
}

@Data
class Car {
    private Optional<Insurance> insurance = Optional.empty();

}
@Data
class Insurance {
    private String name;
}