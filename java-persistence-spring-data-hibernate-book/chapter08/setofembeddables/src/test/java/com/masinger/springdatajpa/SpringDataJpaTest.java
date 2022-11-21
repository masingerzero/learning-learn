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

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    private ItemRepository itemRepository;

    @Test
    void storeLoadEntities() {
        Set<Image> imageSet = Set.of(new Image("imageA.jpg", 10, 20),
                new Image("imageB.jpg", 12, 42),
                new Image("imageC.jpg", 133, 420)


        );

        Item item1 = new Item("item 1");
        imageSet.forEach(item1::addImage);

        Item savedItem = itemRepository.save(item1);

        Item item2 = new Item("item 2");
        imageSet.forEach(item2::addImage);

        Item savedItem2 = itemRepository.save(item2);

        Item itemWithImages1 = itemRepository.findItemWithImages(savedItem.getId());
        Item itemWithImages2 = itemRepository.findItemWithImages(savedItem2.getId());

        Set<Image> allImages = new HashSet<>();
        allImages.addAll(itemWithImages1.getImages());
        allImages.addAll(itemWithImages2.getImages());

        System.out.println(allImages);


    }

    @Test
    public void testMergeImagesSet() {
        Set<Image> imageSet = Set.of(new Image("imageA.jpg", 10, 20),
                new Image("imageB.jpg", 12, 42),
                new Image("imageC.jpg", 133, 420)


        );

        Item item1 = new Item("item 1");
        imageSet.forEach(item1::addImage);
        Item savedItem = itemRepository.save(item1);

        Item item2 = new Item("item 2");
        imageSet.forEach(item2::addImage);
        Item savedItem2 = itemRepository.save(item2);

        Item itemWithImages1 = itemRepository.findItemWithImages(savedItem.getId());
        Item itemWithImages2 = itemRepository.findItemWithImages(savedItem2.getId());

        Set<Image> allImages = new HashSet<>();
        allImages.addAll(itemWithImages1.getImages());
        allImages.addAll(itemWithImages2.getImages());
        Assertions.assertEquals(6, allImages.size());

    }
}
