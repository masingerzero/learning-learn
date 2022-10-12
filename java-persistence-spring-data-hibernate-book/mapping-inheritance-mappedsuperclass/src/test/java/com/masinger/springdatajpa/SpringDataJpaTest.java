package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.BankAccount;
import com.masinger.springdatajpa.model.CreditCard;
import com.masinger.springdatajpa.repositories.CreditCardRepository;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    CreditCardRepository creditCardRepository;


    @Test
    void storeLoadEntities() {
        CreditCard creditCard = new CreditCard();
        BankAccount bankAccount = new BankAccount();

    }
}
