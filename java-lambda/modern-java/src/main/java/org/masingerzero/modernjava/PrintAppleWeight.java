package org.masingerzero.modernjava;

public class PrintAppleWeight implements AppleFormatter {

	@Override
	public String format(Apple apple) {
		return String.format("Apple{weight=%d}", apple.getWeight());
	}

}
