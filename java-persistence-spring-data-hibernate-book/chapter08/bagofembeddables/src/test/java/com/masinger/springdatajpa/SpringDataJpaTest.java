package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Image;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.ItemRepository;
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
        Item item1 = new Item("name");
        Collection<Image> images = new ArrayList<>();
        images.add(new Image("the title A", "imageA.jpg",10, 20));
        images.add(new Image("the title B", "imageB.jpg",58, 88));
        images.add(new Image("the title C", "imageC.jpg",11, 445));
        images.add(new Image("the title A", "imageA.jpg",10, 20));
        images.add(new Image("the title B", "imageB.jpg",58, 88));
        images.add(new Image("the title C", "imageC.jpg",11, 445));
        images.add(new Image(null, "imageX.jpg",110, 445));


        images.forEach(item1::addImage);

        Item savedItem1 = itemRepository.save(item1);


    }
}
