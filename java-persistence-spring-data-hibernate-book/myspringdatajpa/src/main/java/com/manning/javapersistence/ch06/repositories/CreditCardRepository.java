package com.manning.javapersistence.ch06.repositories;


import com.manning.javapersistence.ch06.model.CreditCard;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CreditCardRepository extends BillingDetailsRepository<CreditCard, Long> {
    List<CreditCard> findByExpYear(String expYear);
}
