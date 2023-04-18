package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Bid;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.BidRepository;
import com.masinger.springdatajpa.repositories.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.Map;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    TestService testService;
    @Test
    void storeLoadEntities() {
        Item someItem = new Item("Some Item");
        itemRepository.save(someItem);

        Bid someBid = new Bid(new BigDecimal("123.00"), someItem);
        bidRepository.save(someBid);
        someItem.addBid(someBid);

        Bid secondBid = new Bid(new BigDecimal("456.00"), someItem);
        bidRepository.save(secondBid);
        someItem.addBid( secondBid);

        Item item = itemRepository.findById(someItem.getId()).get();

        Assertions.assertEquals(2, item.getBids().size());

        for (Map.Entry<Long, Bid> entry : item.getBids().entrySet()) {
            // The key is the identifier of each Bid
            Assertions.assertEquals(entry.getKey(), entry.getValue().getId());
        }

    }

    @Test
    void throughTestServiceStoreAndLoadEntities() {
        testService.storeAndLoadEntities();
    }
}
