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

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    ItemRepository itemRepository;
    @Test
    void storeLoadEntities() {
        Item item1 = new Item("item 1");
        item1.addImage("a.jpg", "one.jpg");
        item1.addImage("c.jpg", "two.jpg");
        item1.addImage("b.jpg", "three.jpg");
        Long item1Id = itemRepository.save(item1).getId();

        Item item2 = new Item("item 2");
        item2.addImage("file3.jpg", "user-file3.jpg");
        item2.addImage("file4.jpg", "user-file4.jpg");
        Long item2Id = itemRepository.save(item2).getId();

//        Item item1Taken = itemRepository.findById(item1Id).get();
//        Item item2Taken = itemRepository.findById(item2Id).get();

//        Item itemById = itemRepository.findItemWithImages(item2Id);
//        System.out.println(itemById.getImages());

        Item itemWithImages = itemRepository.findItemWithImages(item1Id);
        System.out.println(itemWithImages.getImages());


    }
}
