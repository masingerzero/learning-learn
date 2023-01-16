package com.masinger.springdatajpa;

import com.masinger.springdatajpa.model.Bid;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.BidRepository;
import com.masinger.springdatajpa.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;

@Service
public class TestService {
    private ItemRepository itemRepository;
    private BidRepository bidRepository;

    protected TestService(ItemRepository itemRepository, BidRepository bidRepository) {
        this.itemRepository = itemRepository;
        this.bidRepository = bidRepository;
    }

    @Transactional
    public void storeAndLoadEntities() {
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
