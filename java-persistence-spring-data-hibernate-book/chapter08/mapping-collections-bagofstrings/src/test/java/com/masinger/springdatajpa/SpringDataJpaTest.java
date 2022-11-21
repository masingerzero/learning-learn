package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.List;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    ItemRepository itemRepository;
    @Test
    void storeLoadEntities() {
        Item item = new Item("item1");
        item.addImage("lemon.jpg");
        item.addImage("orange.jpg");
        item.addImage("apple.jpg");

        Long id = itemRepository.save(item).getId();

        Collection<String> images = itemRepository.findById(id).get().getImages();
        for (String image : images) {
            System.out.println(image);
        }


    }
}
