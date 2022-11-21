package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.BankAccount;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface BankAccountRepository extends BillingDetailsRepository<BankAccount, Long> {
    List<BankAccount> findBySwift(String swift);



}
