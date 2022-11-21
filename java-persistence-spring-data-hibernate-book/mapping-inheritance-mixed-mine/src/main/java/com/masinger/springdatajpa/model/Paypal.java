package com.masinger.springdatajpa.model;

import javax.persistence.*;

@Entity
@SecondaryTable(name = "PAYPAL",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "PAYPAL_ID")
)
@DiscriminatorValue("PP")
public class Paypal extends BillingDetails {

    @Column(table = "PAYPAL", nullable = false)
    private String email;

    @Column(table = "PAYPAL", nullable = false)
    private String password;

    protected Paypal() {
    }

    public Paypal(String owner, String email, String password) {
        super(owner);
        this.email = email;
        this.password = password;
    }
}
