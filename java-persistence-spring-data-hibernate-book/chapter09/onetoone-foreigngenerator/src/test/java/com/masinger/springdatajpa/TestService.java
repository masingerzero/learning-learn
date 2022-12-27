package com.masinger.springdatajpa;

import com.masinger.springdatajpa.model.Address;
import com.masinger.springdatajpa.model.User;
import com.masinger.springdatajpa.repositories.AddressRepository;
import com.masinger.springdatajpa.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class TestService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Transactional
    public void storeAndLoadEntities() {
        User user = new User("John");
        Address address = new Address("torrevieja", "8320", "Pinto", user);
        userRepository.save(user);

        Optional<User> savedUser = userRepository.findById(user.getId());
        Assertions.assertAll(
                () -> Assertions.assertEquals("John", savedUser.get().getName()),
                () -> Assertions.assertEquals("torrevieja", savedUser.get().getShippingAddress().getStreet()),
                () -> Assertions.assertEquals("8320", savedUser.get().getShippingAddress().getZipcode()),
                () -> Assertions.assertEquals("Pinto", savedUser.get().getShippingAddress().getCity())

        );

//        userRepository.delete(savedUser.get());
//        Assertions.assertAll(
//                () -> Assertions.assertTrue(userRepository.findById(user.getId()).isEmpty()),
//                () -> Assertions.assertTrue(addressRepository.findById(user.getShippingAddress().getId()).isEmpty())
//        );
    }
}
