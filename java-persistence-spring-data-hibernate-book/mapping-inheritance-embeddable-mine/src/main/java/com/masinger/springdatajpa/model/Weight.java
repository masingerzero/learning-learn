package com.masinger.springdatajpa.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
@AttributeOverride(name = "unitName", column = @Column(name = "weight_unit"))
public class Weight extends Measurement {
    @NotNull
    private int weight;

    protected Weight() {}
    public Weight(String unitName, String symbol, int weight) {
        super(unitName, symbol);
        this.weight = weight;
    }
}
