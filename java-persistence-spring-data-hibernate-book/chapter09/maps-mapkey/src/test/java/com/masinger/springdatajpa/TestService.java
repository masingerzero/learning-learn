package com.masinger.springdatajpa;

import com.masinger.springdatajpa.model.Bid;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.BidRepository;
import com.masinger.springdatajpa.repositories.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Map;

@Service
public class TestService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private BidRepository bidRepository;
    @Transactional
    public void storeAndLoadEntities() {

        Item someItem = new Item("Some Item");
        itemRepository.save(someItem);

        Item anotherItem = new Item( "Another Item");
        itemRepository.save(anotherItem);

        Bid someBid = new Bid(new BigDecimal("123.00"), someItem);
        bidRepository.save(someBid);
        someItem.addBid(someBid);

        //This fail
        anotherItem.addBid(someBid);

        Bid secondBid = new Bid(new BigDecimal("456.00"), someItem);
        bidRepository.save(secondBid);
        someItem.addBid( secondBid);

        Item item = itemRepository.findById(someItem.getId()).get();

        Assertions.assertEquals(2, item.getBids().size());

        item.getBids().forEach((key, value) -> Assertions.assertEquals(key, value.getId()));
//        for (Map.Entry<Long, Bid> entry : item.getBids().entrySet()) {
//            // The key is the identifier of each Bid
//            Assertions.assertEquals(entry.getKey(), entry.getValue().getId());
//        }
    }
}
