package org.masingerzero.modernjava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.ToIntFunction;

public class MethodReferences {

	
	public static void main(String[] args) {
		List<Apple> inventory = new ArrayList<>();
	    inventory.addAll(Arrays.asList(
	        new Apple(80, Color.GREEN),
	        new Apple(155, Color.GREEN),
	        new Apple(120, Color.RED)
	    ));
	    
	    
	    inventory.sort((a1, a2) -> a1.getWeight() - a2.getWeight());
	    
	    inventory.sort(Comparator.comparing((Apple apple) -> apple.getWeight()));
	    inventory.sort(Comparator.comparing(Apple::getWeight));
	    
	    ToIntFunction<String> stringToInt = s -> Integer.parseInt(s);
	    int theInt = stringToInt.applyAsInt("3");
	    System.out.println(theInt);
	    
	    stringToInt = new ToIntFunction<String>() {
			@Override
			public int applyAsInt(String value) {
				return Integer.parseInt(value);
			}
		};
	    theInt = stringToInt.applyAsInt("5");
	    System.out.println(theInt);
	    
	    
	    
	    
	    
	    
	    
	    
	    List<String> str = Arrays.asList("a","b","A","B");
	    
	    BiPredicate<List<String>, String> contains = new BiPredicate<List<String>, String>() {
			@Override
			public boolean test(List<String> list, String element) {
				return list.contains(element);
			}
		};
	    
	    
	    contains = (list, element) -> list.contains(element);
	    
	    
	    contains = List<String>::contains;
	    
	    contains = (t, u) -> t.contains(u);
	    
	    boolean test = contains.test(str, "A");
	}
	
	
	
	
	
	
	
	
}
