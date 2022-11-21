package com.masinger.springdatajpa.setofstrings;

import com.masinger.springdatajpa.configuration.setofstrings.SpringDataConfiguration;
import com.masinger.springdatajpa.model.setofstrings.Item;
import com.masinger.springdatajpa.repositories.setofstrings.ItemRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    ItemRepository itemRepository;

    @Test
    void storeLoadEntities() {



        Item item = new Item("an-item");

        item.add("lemon.jpg");
        item.add("orange.gif");
        Item item1 = itemRepository.save(item);

        Set<String> imagesNative = itemRepository.findImagesNative(item.getId());
        System.out.println(imagesNative);
//        Set<String> images1 = itemRepository.findItemWithImages(item1.getId()).getImages();
//        System.out.println(images1);
//
//        Set<String> images = itemRepository.findById(item1.getId()).get().getImages();
//        System.out.println(images);

//        Item itemWithImages = itemRepository.findItemWithImages(item1.getId());
//        Set<String> images = itemRepository.findImagesNative(item1.getId());

//        Item item2 = itemRepository.findById(1L).get();
//        Set<String> images = item2.getImages();

        List<Item> items = itemRepository.findAll();

        items.stream()
                .map(Item::getImages)
                .flatMap(Collection::stream)
                .forEach(System.out::println);

//        Set<String> images = items.get(0).getImages();

//        assertAll(
//                () -> assertEquals(2, itemWithImages.getImages().size()),
//                () -> assertEquals(2, images.size())
//                () -> assertEquals(2, items.get(0).getImages())

//        );
    }


}
