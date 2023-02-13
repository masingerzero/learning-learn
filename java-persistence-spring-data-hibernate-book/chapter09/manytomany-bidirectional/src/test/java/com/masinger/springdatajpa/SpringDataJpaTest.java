package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Category;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.CategoryRepository;
import com.masinger.springdatajpa.repositories.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    TestService testService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ItemRepository itemRepository;
    @Test
    void storeLoadEntities() {
        Category someCategory = new Category("someCategory");
        Category anotherCategory = new Category("anotherCategory");
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
//        itemRepository.save(item1);
//        itemRepository.save(item2);
//
        someCategory.addItem(item1);
        someCategory.addItem(item2);
        anotherCategory.addItem(item1);
        anotherCategory.addItem(item2);

        categoryRepository.save(someCategory);
        categoryRepository.save(anotherCategory);


    }

@Test
    void testOther() {
        testService.storeAndLoadEntities();
    }

    @Test
    void testNothing() {

    }
}
