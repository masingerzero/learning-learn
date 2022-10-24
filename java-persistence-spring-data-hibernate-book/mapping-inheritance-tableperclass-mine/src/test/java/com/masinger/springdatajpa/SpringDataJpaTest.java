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
    BankAccountRepository bankAccountRepository;

    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    BillingDetailsRepository<BillingDetails, Long> billingDetailsRepository;


    @Test
    void storeLoadEntities() {
        BankAccount bankAccount1 = new BankAccount("juan", "11111", "ING", "122");
        bankAccountRepository.save(bankAccount1);
        CreditCard creditCard1 = new CreditCard("pepe", "1312313123", "October", "2000");
        creditCardRepository.save(creditCard1);


        List<BankAccount> bankAccounts = bankAccountRepository.findBySwift("122");
        List<CreditCard> creditCards = creditCardRepository.findByExpYear("2000");

        List<BillingDetails> billingDetails = billingDetailsRepository.findAll();

        List<BillingDetails> juanBillingDetails = billingDetailsRepository.findByOwner("juan");

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, bankAccounts.size()),
                () -> Assertions.assertEquals(1, creditCards.size()),
                () -> Assertions.assertEquals(2, billingDetails.size()));

//        billingDetailsRepository.deleteAll();
//        billingDetailsRepository.save(bankAccount1);


    }
}
