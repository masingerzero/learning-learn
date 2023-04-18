package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    private Long id;

    private String name;

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }
}
