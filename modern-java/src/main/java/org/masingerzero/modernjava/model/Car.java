package org.masingerzero.modernjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Car {
    private String name;
    private String brand;
    private Color color;
    public enum Color {
        BLACK, WHITE, RED, BLUE, ORANGE
    }
}
