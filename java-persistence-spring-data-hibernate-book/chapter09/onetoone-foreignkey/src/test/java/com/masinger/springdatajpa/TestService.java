package com.masinger.springdatajpa;

import com.masinger.springdatajpa.model.Address;
import com.masinger.springdatajpa.model.User;
import com.masinger.springdatajpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TestService {
    @Autowired
    UserRepository userRepository;

    @Transactional
    public void storeLoadEntities() {
        User user = new User("John", "Lin");
        Address shippingAddress = new Address("Torrevieja", "28320", "Pinto");
        user.setShippingAddress(shippingAddress);
        userRepository.save(user);
    }
}
