package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    void storeLoadEntities() {
        Item item = new Item("item1");
        item.addImage("image1.jpg");
        item.addImage("image2.gif");
        item.addImage("image3.png");

        Item item2 = new Item("item2");
        item2.addImage("orange.jpg");
        item2.addImage("fruit.gif");
        item2.addImage("car.png");

        Item item1 = itemRepository.save(item);
        itemRepository.save(item2);


        List<Item> items = itemRepository.fetchAllItems();
        long count = items.stream()
                .flatMap(item3 -> item3.getImages().stream())
                .count();
        System.out.println(count);


    }
}
