package com.masinger.springdatajpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long Id;
    @NotNull
    private String userName;

    @OneToMany(mappedBy = "user")
    private Set<BillingDetails> billingDetails = new HashSet<>();

    protected User() {

    }

    public User(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<BillingDetails> getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(Set<BillingDetails> billingDetails) {
        this.billingDetails = billingDetails;
    }
}
