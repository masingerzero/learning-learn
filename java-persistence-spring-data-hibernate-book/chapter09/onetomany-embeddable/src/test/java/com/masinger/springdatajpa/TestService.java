package com.masinger.springdatajpa;

import com.masinger.springdatajpa.model.Address;
import com.masinger.springdatajpa.model.Shipment;
import com.masinger.springdatajpa.model.User;
import com.masinger.springdatajpa.repositories.ShipmentRepository;
import com.masinger.springdatajpa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
public class TestService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShipmentRepository shipmentRepository;
    @Transactional
    public void storeAndLoadEntities() {
        Address address = new Address("the street", "the zipcode", "the city");
        User user = new User("Tom", address);
        Shipment shipment = new Shipment(new Date());
        address.addShipment(shipment);
        userRepository.save(user);
        shipmentRepository.save(shipment);
    }

}
