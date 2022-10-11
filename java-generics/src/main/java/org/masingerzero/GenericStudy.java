package org.masingerzero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

class Animal implements Comparable<Animal> {
    private String name;
    private Integer weight;

    public Animal(String name, Integer weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Animal animal) {
        return
                this.weight.compareTo(animal.weight);
    }
}

//class Animal {
//    private String name;
//    private Integer weight;
//
//    public Animal(String name, Integer weight) {
//        this.name = name;
//        this.weight = weight;
//    }
//
//}


class Lion extends Animal {
    public Lion(String name, Integer weight) {
        super(name, weight);
    }
}

class Gorilla extends Animal
{
    public Gorilla(String name, Integer weight) {
        super(name, weight);
    }
}

class GenericTest {

    public static void main(String[] args) {
        Collection<Gorilla> gorillas = Arrays.asList(new Gorilla("gorillaOne", 300), new Gorilla("GorillaTwo", 400));
//        Collection<Animal> animals = Arrays.asList(new Gorilla("gorillaOne", 300), new Lion("LionOne", 500));
//        maxNoWildcards(animals);
//        GenericTest.maxNoWildcards(gorillas);

//        maxWildcards(gorillas);
//        Comparable<Animal> i = new Animal("animal", 1000);
//        Comparable<Gorilla> y = new Gorilla("gory", 3000);
//        Gorilla g = new Gorilla("" , 200);
//        Comparable<? super Gorilla> gori1 = null;
//        Comparable<? super Gorilla> z = new Gorilla("gorilla", 222);
//        List<? super Gorilla> animals = new ArrayList<Gorilla>();

//        Comparable<Gorilla> gorillaComparable = new Gorilla("gorilla1", 100);

        // Is like with numbers
//        Comparable<? super Comparable<Gorilla>> gorilla = new Gorilla("gorilla", 1000);

//        Comparable<? super Animal> comparable

        // Like List<Number> and List<Integer>, the former is no a supertype of the latest though Number is supertype
        // of Integer
//        List<Number> numbers = new ArrayList<Integer>(); // Compile time error
        // The same occurs Comparable<Animal> and Comparable<Gorilla>

//        Comparable<Animal> animal = new Comparable<>() {
//            @Override
//            public int compareTo(Gorilla o) {
//                return 0;
//            }
//        };

//        Comparable<Lion> lionComparable = new Lion("LionOne", 1000);
//        Comparable<Gorilla> gorillaComparable = new Lion("GorillaOne", 900);
//
//        Comparable<Animal> lionComparable1 = new Lion("LionOne", 1000);
//        Comparable<Animal> gorillaComparable1 = new Lion("GorillaOne", 900);


        //Comparable<Animal> != Comparable<Gorilla>

        // for a Gorilla extending from Animal implements Comparable<Animal> there is no match
        // for <T extends Comparable<T>> ==> <T extends Comparable<Gorilla>>. Gorilla implements Comparable<Animal>
        // however a gorilla implements Comparable<Animal>, so if you want to allow compare gorilla you must change the
        // bound of T to <T extends Comparable<? super T> that tells that accept that gorilla extends comparable or there
        // is a Comparable defined in a super type.

        Gorilla gorilla = new Gorilla("gorilla", 3000);
        gorilla.compareTo(new Lion("lion", 1000));



    }

    public static <T extends Comparable<T>> void maxNoWildcards(Collection<T> collection) {

    }

//    public static <T extends Comparable<? super T>> void maxWildcards(Collection<? extends T> collection) {
//
//    }


}