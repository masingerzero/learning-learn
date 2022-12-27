package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Image;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Collection;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    void storeLoadEntities() {
        Item item1 = new Item("item 1");
        item1.addImage("title image 1", new Image("image1fn", 10, 20));
        item1.addImage("title image 2", new Image("image2fn", 100, 15));
        item1.addImage("title image 3", new Image("image3fn", 10, 20));

        Item savedItem1 = itemRepository.save(item1);

        Item item2 = new Item("item 2");
        item2.addImage("title image 1", new Image("image1fn", 10, 20));
        item2.addImage("title image 2", new Image("image2fn", 100, 15));
        item2.addImage("title image 3", new Image("image3fn", 10, 20));

        Item savedItem2 = itemRepository.save(item2);

        Assertions.assertAll(
                () -> Assertions.assertEquals(3, itemRepository.findItemWithImages(item1.getId()).getImages().size()),
                () -> Assertions.assertEquals(3, itemRepository.findItemWithImages(item2.getId()).getImages().size())

        );



    }
}
