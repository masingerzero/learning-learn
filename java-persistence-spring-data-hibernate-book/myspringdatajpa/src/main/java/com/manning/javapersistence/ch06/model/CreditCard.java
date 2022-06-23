package com.manning.javapersistence.ch06.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;



@Entity
@DiscriminatorValue("CC")
@SecondaryTable(
        name = "CREDITCARD",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "CREDITCARD_ID")
)
public class CreditCard extends BillingDetails {
    @NotNull
    @Column(table = "CREDITCARD", nullable = false)
    private String cardNumber;

    @NotNull
    @Column(table = "CREDITCARD", nullable = false)
    private String expMonth;

    @NotNull
    @Column(table = "CREDITCARD", nullable = false)
    private String expYear;

    public CreditCard() {
    }

    public CreditCard(String owner, String number, String expMonth, String expYear) {
        super(owner);
        this.cardNumber = number;
        this.expMonth = expMonth;
        this.expYear = expYear;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(String expMonth) {
        this.expMonth = expMonth;
    }

    public String getExpYear() {
        return expYear;
    }

    public void setExpYear(String expYear) {
        this.expYear = expYear;
    }
}

