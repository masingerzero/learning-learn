package org.masingerzero.modernjava.chapter11;

import lombok.Data;
import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Assertions;

import java.util.Optional;
import java.util.Properties;

public class Chapter11SandBox {
    public static void main(String[] args) {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        Assertions.assertEquals(5, readDurationV1(props, "a"));
        Assertions.assertEquals(0, readDurationV1(props, "b"));
        Assertions.assertEquals(0, readDurationV1(props, "c"));
        Assertions.assertEquals(0, readDurationV1(props, "d"));

        Assertions.assertEquals(5, readDurationV2(props, "a"));
        Assertions.assertEquals(0, readDurationV2(props, "b"));
        Assertions.assertEquals(0, readDurationV2(props, "c"));
        Assertions.assertEquals(0, readDurationV2(props, "d"));

        Assertions.assertEquals(5, readDurationV3(props, "a"));
        Assertions.assertEquals(0, readDurationV3(props, "b"));
        Assertions.assertEquals(0, readDurationV3(props, "c"));
        Assertions.assertEquals(0, readDurationV3(props, "d"));


    }

    public static int readDuration(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int duration = Integer.parseInt(value);
                if (duration > 0) {
                    return duration;
                }
            } catch (NumberFormatException e) { }

        }
        return 0;
    }

    public static int readDurationV1(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(Chapter11SandBox::optionalParseInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

    public static int readDurationV2(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(value -> {
                    int duration = 0;
                    try {
                        duration = Integer.parseInt(value);

                    } catch (NumberFormatException e) {}
                    return Optional.of(duration);
                })
                .filter(duration -> duration > 0)
                .orElse(0);
    }

    public static int readDurationV3(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .filter(NumberUtils::isCreatable)
                .map(Integer::parseInt)
                .filter(duration -> duration > 0)
                .orElse(0);
    }

    public static Optional<Integer> optionalParseInt(String value) {
        try {
            return Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }


    public static Optional<Insurance> nullSafeCheapestInsurance(Optional<Person> person, Optional<Car> car) {
        if (person.isPresent() && car.isPresent()) {
            return Optional.of(findTheCheapestInsurance(person.get(), car.get()));
        } else {
            return Optional.empty();
        }
    }

    public static Optional<Insurance> nullSafeCheapestInsuranceV1(Optional<Person> person, Optional<Car> car) {
        if (person.flatMap(p -> car).isPresent()) {
            return Optional.of(findTheCheapestInsurance(person.get(), car.get()));
        };
        return Optional.empty();
    }

    public static Optional<Insurance> nullSafeCheapestInsuranceV2(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car).map(c -> findTheCheapestInsurance(person.get(), c));
    }

    public static Optional<Insurance> nullSafeCheapestInsuranceV3(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findTheCheapestInsurance(p, c)));

    }

    public static Optional<Insurance> nullSafeCheapestInsuranceV4(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findTheCheapestInsurance(p, c)));
    }

    public static Optional<Insurance> nullSafeCheapestInsuranceV5(Optional<Person> person) {
        person.flatMap(p -> p.getCar().map(c -> findTheCheapestInsurance(p, c)));
        return null;
    }



    public static String getCarInsuranceName(Optional<Person> person, int minAge) {

        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("No insurance!!!!");

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
//    private Optional<List<Car>> cars = Optional.empty();
    private Optional<Car> car = Optional.empty();

    private int age;
}

@Data
class Car {
    private Optional<Insurance> insurance = Optional.empty();

}
@Data
class Insurance {
    private String name;
}