package com.manning.javapersistence.ch10;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Bid {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;
    protected Bid() {};




}
