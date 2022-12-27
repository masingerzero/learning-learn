package org.masingerzero.modernjava.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class Order {

    public String customer;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    private List<Trade> trades = new ArrayList<>();

    public Order(String customer) {
        this.customer = customer;
    }

    public void addTrade(Trade trade) {
        this.trades.add(trade);
    }

    public double getValue() {
        return trades.stream()
                .mapToDouble(Trade::getValue)
                .sum();
    }
}
