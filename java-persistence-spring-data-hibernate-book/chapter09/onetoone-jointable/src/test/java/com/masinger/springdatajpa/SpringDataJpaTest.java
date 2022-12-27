package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.model.Shipment;
import com.masinger.springdatajpa.repositories.ShipmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    ShipmentRepository shipmentRepository;
    @Test
    void storeLoadEntities() {
        Item item = new Item("painting");
        Shipment shipment = new Shipment("shipped", item);
        shipmentRepository.save(shipment);

//        Shipment savedShipment = shipmentRepository.findById(shipment.getId()).get();
        Item auction = shipmentRepository.findByIdWithAuction(shipment.getId()).getAuction();
        System.out.println(auction);

    }
}
