package com.manning.javapersistence.ch06.repositories;


import com.manning.javapersistence.ch06.model.BankAccount;
import com.manning.javapersistence.ch06.model.CreditCard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends BillingDetailsRepository<BankAccount, Long> {
    List<BankAccount> findBySwift(String swift);
}
