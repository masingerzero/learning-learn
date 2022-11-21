package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.BankAccount;
import com.masinger.springdatajpa.model.BillingDetails;
import com.masinger.springdatajpa.model.CreditCard;
import com.masinger.springdatajpa.model.User;
import com.masinger.springdatajpa.repositories.BillingDetailsRepository;
import com.masinger.springdatajpa.repositories.CreditCardRepository;
import com.masinger.springdatajpa.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    private UserRepository userRepository;



    @Autowired
    BillingDetailsRepository<BillingDetails, Long> billingDetailsRepository;


    @Test
    void storeLoadEntities() {
        CreditCard creditCard = new CreditCard("owner", "11111111", "February", "2032" );
        billingDetailsRepository.save(creditCard);
        BankAccount bankAccount = new BankAccount("ba owner", "21234234234", "1232", "ing");
        billingDetailsRepository.save(creditCard);
        billingDetailsRepository.save(bankAccount);
        User user = new User("coco");
        Set<BillingDetails> billingDetails = new HashSet<>();
        billingDetails.add(creditCard);
        billingDetails.add(bankAccount);
        user.setBillingDetails(billingDetails);
        userRepository.save(user);

        List<User> all = userRepository.findAll();
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, user.getBillingDetails().size())
        );



    }
}
