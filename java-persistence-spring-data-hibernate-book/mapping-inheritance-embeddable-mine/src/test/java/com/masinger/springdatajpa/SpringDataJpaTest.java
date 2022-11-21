package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Dimensions;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.model.Weight;
import com.masinger.springdatajpa.repositories.ItemRepository;
import org.junit.jupiter.api.Assertions;
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
        Item item = new Item("Item");
        item.setDimensions(new Dimensions("centimeters", "cm", 10, 20, 10));
        item.setWeight(new Weight("kilograms","kg", 10));
        itemRepository.save(item);
        List<Item> all = itemRepository.findAll();
        Assertions.assertAll(
                () -> Assertions.assertEquals(1, all.size())
        );
    }
}
