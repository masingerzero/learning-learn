package org.masingerzero.modernjava;

import static org.masingerzero.modernjava.Color.GREEN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MyFilteringApples2 {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, Color.GREEN), new Apple(155, Color.GREEN),
				new Apple(120, Color.RED));

		List<Double> ints = Arrays.asList(1d, 2d, 3d);
//		List<Apple> greenApples = filterApples(inventory, MyFilteringApples2::isGreenApple);
//		System.out.println(greenApples);
//		
//		
//		List<Apple> heavyApples = filterApples(inventory, MyFilteringApples2::isHeavyApple);
//		System.out.println(heavyApples);

//		List<Apple> greenApples = filterApples(inventory, Apple::isGreenApple);
//		System.out.println(greenApples);
//
//		filterApples(inventory, (Apple a) -> GREEN.equals(a.getColor()));
//		filterApples(inventory, (Apple a) -> a.getWeight() > 150);
//		filterApples(inventory, (Apple a) -> a.getWeight() < 180 || RED.equals(a.getColor()));
//		
//		
//		List<Apple> heavyApples = inventory.stream().filter((Apple a) -> a.getWeight() > 150)
//				.collect(toList());
//		System.out.println(heavyApples);
//		List<Apple> heavyApplesParallelVersion = inventory.parallelStream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
//		System.out.println(heavyApplesParallelVersion);

		// prettyPrintApple(inventory, new PrintAppleWeight());
		// prettyPrintApple(inventory, new PrintAppleInfo());

		filter(inventory, a -> GREEN.equals(GREEN));
		filter(ints, a -> GREEN.equals(GREEN));
//		System.out.println(filteredList);

		List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		List<Integer> evenNumbers = filter(integers, (Integer i) -> i % 2 == 0);
		System.out.println(evenNumbers);

		System.out.println(inventory);
		inventory.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple a1, Apple a2) {

				return Integer.valueOf(a1.getWeight()).compareTo(Integer.valueOf(a2.getWeight()));
			}
		});

		System.out.println(inventory);

		// in lambda expression
		Comparator<Apple> c = (Apple a1, Apple a2) -> Integer.valueOf(a1.getWeight())
				.compareTo(Integer.valueOf(a2.getWeight()));
		inventory.sort(c);

		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("Thread t running");

			}
		});

		t.run();
		
		//With lambda expression
		t = new Thread(() -> System.out.println("running running"));
		t.run();
		
		TestFoo();
		
		testCommand();
		
		
		process(() -> {System.out.println("This is awesome!!!");});
	}

	public static boolean isGreenApple(Apple apple) {
		return GREEN.equals(apple.getColor());
	}

	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}

	// Create a generic filter that get a list of elements and filter in function of
	// a predicate

	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T element : list) {
			if (p.test(element)) {
				result.add(element);
			}
		}
		return result;
	}

	static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple)) {
				result.add(apple);
			}
		}
		return result;
	}

	public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formater) {
		for (Apple apple : inventory) {
			System.out.println(formater.format(apple));
		}
	}

	public static void process(Runnable r) {
		r.run();
	}
	
	public static void TestFoo() {
		Foo<Apple> fooInteger = () -> new Apple(3, GREEN);
		Apple apple1 = fooInteger.accept();
		System.out.println(apple1);
	}
	
	
	public static void testCommand() {
		Command c = () -> {
			System.out.println("working...");
			int a = 3;
			System.out.println(String.format("a = %d", a));
			System.out.println("FIN del comando");
		};
		
		
		c.doWork();
	}
	
	  @FunctionalInterface
	  interface Foo<T> {
		   T accept();
	  }
	  
	  interface Command {
		  void doWork();
	  }
	  
	
}
