package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.BankAccount;
import com.masinger.springdatajpa.model.BillingDetails;

public interface BankAccountRepository extends BillingDetailsRepository<BankAccount, Long> {
}
