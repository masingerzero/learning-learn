package com.masinger.springdatajpa.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;


//@Embeddable
public class Address {
    private String country;

    private String city;
}