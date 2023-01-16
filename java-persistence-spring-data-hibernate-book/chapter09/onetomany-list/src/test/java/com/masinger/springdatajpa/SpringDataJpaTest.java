package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Bid;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.BidRepository;
import com.masinger.springdatajpa.repositories.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BidRepository bidRepository;

    @Autowired
    private TestService testService;
    @Test
    void storeLoadEntities() {
        testService.storeAndLoadEntities();
    }

    @Test
    public void anotherStoreLoad() {
//        Item item = new Item("item 1");
//        itemRepository.save(item);
//        Bid bid1 = new Bid(BigDecimal.valueOf(100), item);
//        Bid bid2 = new Bid(BigDecimal.valueOf(200), item);
//
//        itemRepository.save(item);
//        bidRepository.save(bid1);
//        bidRepository.save(bid2);
//        item.addBid(bid1);
//        item.addBid(bid2);

    }

    @Test
    public void fooTest() {

    }

    @Test
    public void testInBook() {
        Item item = new Item("Foo");
        itemRepository.save(item);

        Bid someBid = new Bid(new BigDecimal("123.00"), item);
        item.addBid(someBid);
        bidRepository.save(someBid);

        Bid secondBid = new Bid(new BigDecimal("456.00"), item);
        item.addBid(secondBid);
        bidRepository.save(secondBid);
    }


}
