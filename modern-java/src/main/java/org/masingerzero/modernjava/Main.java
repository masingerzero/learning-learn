package org.masingerzero.modernjava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {


    public static void main(String[] args) {

        Integer integer = Integer.valueOf(3);
        Comparator<Car> carComparator = Comparator.comparing(Car::getName).thenComparing(Car::getBrand);
        Main main = new Main();
        Car car1 = main.new Car();
        List<Car> cars = new ArrayList<>();
        cars.add(car1);
        cars.sort(carComparator);
    }

    class Car {
        private String name;

        private String brand;

        public String getName() {
            return name;
        }

        public String getBrand() {
            return brand;
        }
    }

	
}
