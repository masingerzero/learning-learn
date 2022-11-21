package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.CreditCard;

import java.util.List;

public interface CreditCardRepository extends BillingDetailsRepository<CreditCard, Long> {
    List<CreditCard> findByCardNumber(String cardNumber);

}
