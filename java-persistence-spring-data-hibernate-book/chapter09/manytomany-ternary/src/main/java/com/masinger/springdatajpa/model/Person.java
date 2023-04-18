package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Entity
//@Table(name = "PERSON")
public class Person {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    private Long id;

    @ElementCollection
    @CollectionTable(name = "PERSON_ADDRESS",
    joinColumns = @JoinColumn(name = "PERSON_ID"))
    private Set<Address> addresses = new HashSet<>();
}
