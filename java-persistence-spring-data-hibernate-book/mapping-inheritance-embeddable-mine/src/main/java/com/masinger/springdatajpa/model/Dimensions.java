package com.masinger.springdatajpa.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverride(name = "unitName", column = @Column(name = "dimension_unit"))
@AttributeOverride(name = "symbol", column = @Column(name = "dimension_symbol"))
public class Dimensions extends Measurement {
    private int width;
    private int height;
    private int deep;

    protected Dimensions() {}
    public Dimensions(String unit, String symbol, int width, int height, int deep) {
        super(unit, symbol);
        this.width = width;
        this.height = height;
        this.deep = deep;
    }
}
