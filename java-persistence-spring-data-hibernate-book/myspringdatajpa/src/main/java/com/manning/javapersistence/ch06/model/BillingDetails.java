package com.manning.javapersistence.ch06.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "DB_TYPE")
public abstract class BillingDetails {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;

    @NotNull
    private String owner;

    public BillingDetails() {
    }

    public BillingDetails(String owner) {
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
