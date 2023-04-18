package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "BID")
public class Bid {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    private Long id;
    @PersistenceContext

    @NotNull
    private BigDecimal amount;

    private Bid() {
    }

    public Bid(BigDecimal amount, Item item) {
        this.amount = amount;
        this.item = item;
    }

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", nullable = false)
    private Item item;

    public Long getId() {
        return id;
    }
}
