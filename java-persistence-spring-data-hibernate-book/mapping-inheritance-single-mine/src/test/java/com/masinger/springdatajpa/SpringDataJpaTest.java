package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.BankAccount;
import com.masinger.springdatajpa.model.BillingDetails;
import com.masinger.springdatajpa.model.CreditCard;
import com.masinger.springdatajpa.repositories.BankAccountRepository;
import com.masinger.springdatajpa.repositories.BillingDetailsRepository;
import com.masinger.springdatajpa.repositories.CreditCardRepository;
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


    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Test
    void storeLoadEntities() {
        CreditCard creditCard01 = new CreditCard("juan", "12312312", "Novenber", "2000");
        creditCardRepository.save(creditCard01);
        BankAccount bankAccount01 = new BankAccount("pepe", "ACC111111", "ing", "swift");
        bankAccountRepository.save(bankAccount01);
        List<BillingDetails> billingDetails = billingDetailsRepository.findAll();
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, billingDetails.size())
        );



    }
}
