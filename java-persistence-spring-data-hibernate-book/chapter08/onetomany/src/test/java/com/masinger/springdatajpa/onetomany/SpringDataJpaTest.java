package com.masinger.springdatajpa.onetomany;

import com.masinger.springdatajpa.configuration.onetomany.SpringDataConfiguration;
import com.masinger.springdatajpa.model.onetomany.Bid;
import com.masinger.springdatajpa.model.onetomany.Item;

import com.masinger.springdatajpa.repositories.onetomay.BidRepository;
import com.masinger.springdatajpa.repositories.onetomay.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    BidRepository bidRepository;

    @Autowired
    ItemRepository itemRepository;


    @Test
//    @Transactional
//    @org.springframework.transaction.annotation.Transactional
//    @Transactional
    void storeLoadEntities() {
        //first the Item that has to exist in order a bid be able to exist.
        Item item = new Item("item 1");
        //Create two bids with the using the created item
        Bid bid1 = new Bid(BigDecimal.valueOf(100), item);
        Bid bid2 = new Bid(BigDecimal.valueOf(200), item);
        // The same thing happens in the database side, hence persist the item
        itemRepository.save(item);
        // We can save the bids now
        bidRepository.save(bid1);
        bidRepository.save(bid2);

        //To maintain integrity in the java side we add the bids to the Item#bids collection
        item.addBid(bid1);
        item.addBid(bid2);
        Set<Bid> bids = bidRepository.findByItem(item);
        Bid bid3 = new Bid(BigDecimal.valueOf(200), item);
        bids.add(bid3);

        List<Item> items = itemRepository.findAll();

        Assertions.assertAll(
                () -> Assertions.assertEquals(1, items.size()),
                () -> Assertions.assertEquals(2, bids.size())

        );
    }


    //    @Test
//    void testPersistOnlyBidRepo() {
//        //first the Item that has to exist in order a bid be able to exist.
//        Item item = new Item("item 1");
//        //Create two bids with the using the created item
//        Bid bid1 = new Bid(BigDecimal.valueOf(100), item);
//        Bid bid2 = new Bid(BigDecimal.valueOf(200), item);
//
//        bidRepository.save(bid1);
//        bidRepository.save(bid2);
//    }
    @Test
    void storeLoadEntitiesBook() {


        Item item = new Item("Foo");
        Bid bid = new Bid(BigDecimal.valueOf(100), item);
        Bid bid2 = new Bid(BigDecimal.valueOf(200), item);

        itemRepository.save(item);
        item.addBid(bid);
        item.addBid(bid2);
        bidRepository.save(bid);
        bidRepository.save(bid2);

        List<Item> items = itemRepository.findAll();
        Set<Bid> bids = bidRepository.findByItem(item);

        assertAll(
                () -> assertEquals(1, items.size()),
                () -> assertEquals(2, bids.size())
        );

    }



    @Test
    public void deleteCascading() {
        Item item = createItemWithBids();
        itemRepository.delete(item);

    }

    @Test
    void propagatePersistOperation() {
        Item item = new Item("Foo");
        Bid bid = new Bid(BigDecimal.valueOf(100), item);
        Bid bid2 = new Bid(BigDecimal.valueOf(200), item);
        item.addBid(bid);
        item.addBid(bid2);
        itemRepository.save(item);


        List<Item> items = itemRepository.findAll();
        Set<Bid> bids = bidRepository.findByItem(item);

        assertAll(
                () -> assertEquals(1, items.size()),
                () -> assertEquals(2, bids.size())
        );

    }

    @Test
    void deleteNoCascadeItem() {
        Item itemWithBids = createItemWithBids();
        Item item = itemRepository.findById(itemWithBids.getId()).get();

        bidRepository.findByItem(item).forEach(bidRepository::delete);
        itemRepository.delete(item);

        Optional<Item> optionalItem = itemRepository.findById(itemWithBids.getId());
        Assertions.assertAll(
                () -> Assertions.assertTrue(optionalItem.isEmpty())
        );

    }


    private Item createItemWithBids() {
        Item item = new Item("Foo");
        Bid bid = new Bid(BigDecimal.valueOf(100), item);
        Bid bid2 = new Bid(BigDecimal.valueOf(200), item);
        item.addBid(bid);
        item.addBid(bid2);
        itemRepository.save(item);
        return item;
    }


}
