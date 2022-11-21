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

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    void storeLoadEntities() {
        Set<Image> images = new LinkedHashSet<>();
        images.add(new Image("image3.jpg", 3000, 200));
        images.add(new Image("image2.jpg", 10, 40));
        images.add(new Image("image1.jpg", 100, 200));


        Item item1 = new Item("item 1");
        images.forEach(item1::addImage);

        Item savedItem1 = itemRepository.save(item1);

        Item retrievedItem1 = itemRepository.findItemWithImages(savedItem1.getId());
        Set<Image> retrievedItem1Images = retrievedItem1.getImages();

        IntStream.rangeClosed(0, images.size() - 1)
                .forEach(index -> {
                    Image createdImage = images.iterator().next();
                    Image savedImage = retrievedItem1Images.iterator().next();
                    Assertions.assertAll(
                            () -> Assertions.assertTrue(createdImage.getFilename().equals(savedImage.getFilename()))
                    );
                });


    }
}
