package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.CategorizedItem;
import com.masinger.springdatajpa.model.Category;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.CategoryRepository;
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
    private ItemRepository itemRepository;

    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    TestService testService;
    @Test
    void storeLoadEntities() {
        Item item1 = new Item("item 1");
        Item item2 = new Item("item 2");
        itemRepository.save(item1);
        itemRepository.save(item2);
        CategorizedItem link1 = new CategorizedItem(item1, "carl");
        CategorizedItem link2 = new CategorizedItem(item2, "perls");
        Category category1 = new Category("category 1");
        category1.addCategorizedItem(link1);
        category1.addCategorizedItem(link1); // this is ignored by the Set

        category1.addCategorizedItem(link2);
        categoryRepository.save(category1);

        Category category2 = new Category("category 2");
        //link1 is a value type. At the java level is shared in  category1.addCategorizedItem(link1);
        // but at the database level insert the values to link with the category2 in the link table.
        category2.addCategorizedItem(link1);

        categoryRepository.save(category2);

        List<Category> categoryForItem = categoryRepository.findCategoryWithCategorizedItems(item1);
        Assertions.assertEquals(2, categoryForItem.size());


    }

    @Test
    void doNothing() {

    }
}
