package org.masingerzero.modernjava;

import org.masingerzero.modernjava.model.Color;

import static org.masingerzero.modernjava.model.Color.GREEN;

/**
 * The apple class
 */

class Apple {

	private Color color;
	private int weight;

	public Apple(int weight, Color color) {
		super();
		this.color = color;
		this.weight = weight;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public boolean isGreenApple() {
		return GREEN.equals(this.getColor());
	}

	public boolean isHeavyApple() {
		return this.getWeight() > 150;
	}

	@Override
	public String toString() {
		return String.format("Apple{color='%s', weight=%d}", color, weight);
	}

}