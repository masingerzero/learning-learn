package org.masingerzero.modernjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class Trade {
    public enum Type {BUY, SELL}
    private Type type;

    private Stock stock;
    private int quantity;
    private double price;

    public double getValue() {
        return quantity * price;
    }
}
