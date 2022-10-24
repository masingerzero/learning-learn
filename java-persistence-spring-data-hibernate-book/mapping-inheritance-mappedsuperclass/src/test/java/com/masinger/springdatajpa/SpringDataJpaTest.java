package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.BankAccount;
import com.masinger.springdatajpa.model.CreditCard;
import com.masinger.springdatajpa.repositories.BankAccountRepository;
import com.masinger.springdatajpa.repositories.CreditCardRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    CreditCardRepository creditCardRepository;

    @Autowired
    BankAccountRepository bankAccountRepository;

    @Test
    void storeLoadEntities() {
        CreditCard creditCard = new CreditCard("John Smith", "123456789", "10", "2030");
        creditCardRepository.save(creditCard);

        BankAccount bankAccount = new BankAccount("Mike Johnson", "12345", "Delta Bank", "BANKXY12");
        bankAccountRepository.save(bankAccount);

        List<CreditCard> creditCards = creditCardRepository.findByOwner("John Smith");
        List<BankAccount> bankAccounts = bankAccountRepository.findByOwner("Mike Johnson");
        List<CreditCard> creditCards2 = creditCardRepository.findByExpYear("2030");
        List<BankAccount> bankAccounts2 = bankAccountRepository.findBySwift("BANKXY12");

        assertAll(
                () -> assertEquals(1, creditCards.size()),
                () -> assertEquals("123456789", creditCards.get(0).getCardNumber()),
                () -> assertEquals(1, bankAccounts.size()),
                () -> assertEquals("12345", bankAccounts.get(0).getAccount()),
                () -> assertEquals(1, creditCards2.size()),
                () -> assertEquals("John Smith", creditCards2.get(0).getOwner()),
                () -> assertEquals(1, bankAccounts2.size()),
                () -> assertEquals("Mike Johnson", bankAccounts2.get(0).getOwner())
        );


    }
}
