package com.masinger.springdatajpa.model;


import org.hibernate.annotations.DiscriminatorFormula;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorFormula("case when cardNumber is not null then 'CC' else 'BA' end")
public abstract class BillingDetails {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long Id;
    private String owner;

    protected BillingDetails (){}

    protected BillingDetails(String owner) {
        this.owner = owner;
    }

    public Long getId() {
        return Id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}
