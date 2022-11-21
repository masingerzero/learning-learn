package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.BankAccount;
import com.masinger.springdatajpa.model.BillingDetails;
import com.masinger.springdatajpa.model.CreditCard;
import com.masinger.springdatajpa.repositories.BankAccountRepository;
import com.masinger.springdatajpa.repositories.BillingDetailsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    BillingDetailsRepository<BillingDetails, Long> billingDetailsRepository;

    @Test
    void storeLoadEntities() {
        CreditCard creditCard01 = new CreditCard("juanfe", "111111", "Febrary", "2022");
        billingDetailsRepository.save(creditCard01);
        BankAccount bankAccount = new BankAccount("pepe", "11111account", "ing", "111");
        billingDetailsRepository.save(bankAccount);

        List<BillingDetails> all = billingDetailsRepository.findAll();
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, all.size())
        );

    }
}
