package com.masinger.springdatajpa.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

@Entity
@PrimaryKeyJoinColumn(name = "CREDITCARD_ID")
public class CreditCard extends BillingDetails {
    @NotNull
    private String number;
    @NotNull
    private String expMonth;
    @NotNull
    private String expYear;

    protected CreditCard() {
    }

    public CreditCard(String owner, String number, String expMonth, String expYear) {
        super(owner);
        this.number = number;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    @Override
    public void pay(int amount) {

    }
}
