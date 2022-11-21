package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.BankAccount;
import com.masinger.springdatajpa.model.BillingDetails;
import com.masinger.springdatajpa.model.CreditCard;
import com.masinger.springdatajpa.model.Paypal;
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
        BankAccount bankAccount01 = new BankAccount("ba_owner", "1111111", "caisa", "112");
        CreditCard creditCard01 = new CreditCard("cc_owner", "1123131414cn", "January", "2022");
        Paypal paypal01 = new Paypal("pay_owner", "cococ@coco.es", "23423234");

        billingDetailsRepository.save(bankAccount01);
        billingDetailsRepository.save(creditCard01);
        billingDetailsRepository.save(paypal01);

        List<BillingDetails> all = billingDetailsRepository.findAll();
        Assertions.assertAll(
                () -> Assertions.assertEquals(3, all.size())
        );
    }
}
