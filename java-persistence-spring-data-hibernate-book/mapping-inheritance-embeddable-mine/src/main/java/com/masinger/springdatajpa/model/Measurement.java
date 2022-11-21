package com.masinger.springdatajpa.model;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

@MappedSuperclass
public abstract class Measurement {
    @NotNull
    private String unitName;
    @NotNull
    private String symbol;

    protected Measurement() {}
    protected Measurement(String unitName, String symbol) {
        this.unitName = unitName;
        this.symbol = symbol;
    }
}
