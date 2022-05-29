package com.manning.javapersistence.ch06.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class City {
    @NotNull
    @Column(nullable = false, length = 5) // Override VARCHAR(255)
    private String zipcode;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private String country;

    public City() {


    }

    public City(String zipcode, String name, String country) {
        this.zipcode = zipcode;
        this.name = name;
        this.country = country;
    }


    public String getZipcode() {
        return zipcode;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }
}
