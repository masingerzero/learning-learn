package org.masingerzero.modernjava;

public class PrintAppleInfo implements AppleFormatter {

	@Override
	public String format(Apple apple) {
		// TODO Auto-generated method stub
		String format = String.format("Apple{color='%s', weight=%d}", apple.getColor(), apple.getWeight());
		if (apple.getWeight() > 150) {
			format = format.concat("\r this is a heavy apple"); 
		} else {
			format = format.concat("\r this is a ligth apple");
		}
		return format;
	}

}
