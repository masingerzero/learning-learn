package com.masinger.springdatajpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class BankAccount extends BillingDetails {

    @NotNull
    @Column(nullable = false)
    private String account;
    @NotNull
    @Column(nullable = false)
    private String bankName;
    @NotNull
    @Column(nullable = false)
    private String swift;

    protected BankAccount() {
    }

    public BankAccount(String owner, String account, String bankName, String swift) {
        super(owner);
        this.account = account;
        this.bankName = bankName;
        this.swift = swift;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getSwift() {
        return swift;
    }

    public void setSwift(String swift) {
        this.swift = swift;
    }
}
