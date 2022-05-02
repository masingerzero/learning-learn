package org.masingerzero.modernjava;

import java.io.File;
import java.io.FileFilter;
import java.util.Arrays;
import java.util.List;

public class MyFilteringApples {

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80, "green"), new Apple(155, "green"), new Apple(120, "red"));

//		File[] hiddenFiles = new File(".").listFiles(new FileFilter() {
//
//			@Override
//			public boolean accept(File file) {
//				// TODO Auto-generated method stub
//				return file.isHidden();
//			}
//			
//		});

//		FileFilter filter = File::isHidden;
//		File[] hiddenFiles = new File(".").listFiles(filter);
//		System.out.println(hiddenFiles);
		
		
		

	}

	
	
	public static class Apple {

		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color) {
			this.weight = weight;
			this.color = color;
		}

		public int getWeight() {
			return weight;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		@SuppressWarnings("boxing")
		@Override
		public String toString() {
			return String.format("Apple{color='%s', weight=%d}", color, weight);
		}
	}
	
	
	

}
