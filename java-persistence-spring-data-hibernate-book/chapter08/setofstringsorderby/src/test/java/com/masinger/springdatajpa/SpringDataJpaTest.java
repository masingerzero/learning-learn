package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    ItemRepository itemRepository;
    @Test
    void storeLoadEntities() {
        Item item1 = new Item("item 1");
        item1.addImage("imageB.jpg");
        item1.addImage("imageZ.jpg");
        item1.addImage("imageT.jpg");

        Item item2 = new Item("item 2");
        item2.addImage("imageB2.jpg");
        item2.addImage("imageZ2.jpg");
        item2.addImage("imageT2.jpg");

        Item savedItem = itemRepository.save(item1);
        Item savedItem2 = itemRepository.save(item2);

        Item itemWithImages = itemRepository.findItemWithImages(savedItem.getId());
        System.out.println(itemWithImages.getImages());

    }
}
