package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Address;
import com.masinger.springdatajpa.model.User;
import com.masinger.springdatajpa.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    UserRepository userRepository;

    @Test
    void storeLoadEntities() {
        User user1 = new User("Sara");
        Address address = new Address("the street", "11002", "Madrid");
        address.addContact("John weyn");
        address.addContact("Patrick swach");
        user1.setAddress(address);
        User savedUser1 = userRepository.save(user1);

        Optional<User> byId = userRepository.findById(savedUser1.getId());
        Set<String> contacts = byId.get().getAddress().getContacts();
        Assertions.assertAll(
                () -> Assertions.assertEquals(2, contacts.size())
        );


    }
}
