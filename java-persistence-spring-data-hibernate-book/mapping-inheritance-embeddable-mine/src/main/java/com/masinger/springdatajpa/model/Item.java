package com.masinger.springdatajpa.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Item {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    @NotNull
    private String name;
    @Embedded
    private Dimensions dimensions;
    @Embedded
    private Weight weight;
    protected Item( ) {

    }
    public Item(String name) {
        this.name = name;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }
}
