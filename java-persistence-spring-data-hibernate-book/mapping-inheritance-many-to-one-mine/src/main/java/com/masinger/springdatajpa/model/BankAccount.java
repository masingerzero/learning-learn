package com.masinger.springdatajpa.model;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class BankAccount extends BillingDetails {
    protected BankAccount(){};

    private String account;
    private String swift;
    private String bankName;

    public BankAccount(String owner, String account, String swift, String bankName) {
        super(owner);
        this.account = account;
        this.swift = swift;
        this.bankName = bankName;
    }

    @Override
    public void pay(int amount) {
        System.out.println("pay...pay...");
    }
}
