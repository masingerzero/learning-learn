package org.masingerzero.modernjava;

import static org.masingerzero.modernjava.Color.GREEN;
import static org.masingerzero.modernjava.Color.RED;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class UsingFunctionalInterfaces {

	public static void main(String[] args) {

		///////////////
		// Predicate<T>
		///////////////
		Predicate<Apple> p = (Apple a) -> GREEN.equals(a.getColor());

		List<Apple> inventory = Arrays.asList(new Apple(80, GREEN), new Apple(155, GREEN), new Apple(120, RED));
		System.out.println(filter(inventory, p));

		p = p.and((Apple a) -> a.getWeight() > 150).or((Apple a) -> RED.equals(a.getColor()));

		System.out.println(filter(inventory, p));

		///////////////
		// Consumer<T>
		///////////////
		forEach(inventory, (Apple a) -> {
			System.out.println("Working on apple " + a);
			a.setWeight(a.getWeight() * 1000);
		});
		System.out.println(inventory);
		
		
		//////////////////
		// Function<T, R>
		//////////////////
		List<Integer> appleWeights = map(inventory, (Apple a) -> a.getWeight());
		System.out.println(appleWeights);

	}

	// Filter a list by predicate
	private static <T> List<T> filter(List<T> elements, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : elements) {
			if (p.test(e)) {
				result.add(e);
			}
		}
		return result;
	}

	// Do operation over elements of a list
	private static <T> void forEach(List<T> list, Consumer<T> c) {
		for (T t : list) {
			c.accept(t);
		}
	}
	
	//Method thas uses Function<T,R> functional interface
	private static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T t : list) {
			result.add(f.apply(t));
		}
		return result;
	}

}





























