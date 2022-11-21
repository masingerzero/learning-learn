package com.masinger.springdatajpa.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CC")
public class CreditCard  extends BillingDetails {

    private String cardNumber;
    private String expMonth;
    private String expYear;


    protected CreditCard() {
    }

    public CreditCard(String owner, String cardNumber, String expMonth, String expYear) {

        super(owner);

        this.cardNumber = cardNumber;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

}
