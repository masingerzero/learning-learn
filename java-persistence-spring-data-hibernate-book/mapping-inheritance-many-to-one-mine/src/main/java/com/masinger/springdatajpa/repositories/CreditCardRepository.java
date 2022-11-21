package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.BillingDetails;
import com.masinger.springdatajpa.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRepository extends BillingDetailsRepository<CreditCard, Long> {
}
