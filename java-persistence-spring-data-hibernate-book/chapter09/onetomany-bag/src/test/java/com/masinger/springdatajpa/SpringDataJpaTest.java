package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Bid;
import com.masinger.springdatajpa.model.Foo;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.BidRepository;
import com.masinger.springdatajpa.repositories.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    BidRepository bidRepository;
    @Test
    void storeLoadEntities() {


        Item item = new Item("Foo");
        itemRepository.save(item);

        Bid someBid = new Bid(new BigDecimal("123.00"), item);
        item.addBid(someBid);
        item.addBid(someBid);
        bidRepository.save(someBid);

        Item item2 = itemRepository.findItemWithBids(item.getId());

        assertAll(
                () -> assertEquals(2, item.getBids().size()),
                () -> assertEquals(1, item2.getBids().size())
        );

        Bid bid = new Bid(new BigDecimal("456.00"), item);
        item.addBid(bid); // No SELECT!
        bidRepository.save(bid);

        Item item3 = itemRepository.findItemWithBids(item.getId());

        assertEquals(2, item3.getBids().size());



    }

    @Test
    @Transactional
    public void testLazyItem() {
        Item item = new Item("Foo");
        itemRepository.save(item);

        Bid someBid = new Bid(new BigDecimal("123.00"), item);
        bidRepository.save(someBid);

//        Bid savedBid = bidRepository.findAll().get(0);
        Bid savedBid = bidRepository.findById(someBid.getId()).get();
        Item item1 = savedBid.getItem();
        System.out.println(item1);
    }
}
