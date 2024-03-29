package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Address;
import com.masinger.springdatajpa.model.Shipment;
import com.masinger.springdatajpa.model.User;
import com.masinger.springdatajpa.repositories.ShipmentRepository;
import com.masinger.springdatajpa.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;

    @Autowired
    private TestService testService;
    @Test
    void storeLoadEntities() {
        Address address = new Address("the street", "the zipcode", "the city");
        User user = new User("Tom", address);
        userRepository.save(user);
        Shipment shipment = new Shipment(new Date());
        address.addShipment(shipment);
        shipmentRepository.save(shipment);
//        userRepository.save(user);


    }

    @Test
    public void fooBar() {
        testService.storeAndLoadEntities();
    }
}
