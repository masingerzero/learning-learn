package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Address;
import com.masinger.springdatajpa.model.User;
import com.masinger.springdatajpa.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TestService testService;

    @Test
    void storeLoadEntities() {
        User user = new User("John", "Lin");
        Address shippingAddress = new Address("Torrevieja", "28320", "Pinto");
        user.setShippingAddress(shippingAddress);
        userRepository.save(user);
        User savedUser = userRepository.findById(user.getId()).get();
        Address shippingAddress1 = savedUser.getShippingAddress();
        System.out.println(shippingAddress1);


    }

    @Test
    public void testService() {
        testService.storeLoadEntities();
    }

}
