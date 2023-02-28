package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.CategorizedItem;
import com.masinger.springdatajpa.model.Category;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.CategorizedItemRepository;
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
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategorizedItemRepository categorizedItemRepository;
    @Autowired
    TestService testService;
    @Test
    void storeLoadEntities() {
        testService.storeAndLoadEntities();
    }

    @Test
    void storeWithoutTransactionalTestService() {
        Category electronicCategory = new Category("electronic");
        Category bookCategory = new Category("books");
        Item javaBook = new Item("java book");
        Item transistorBook = new Item("transistor documentation");
        Item appleComputer = new Item("Apple computer");
        Item theThreePigs = new Item("the three pigs");
        categoryRepository.save(electronicCategory);
        itemRepository.save(javaBook);
        CategorizedItem electronicJavaBook = new CategorizedItem("user1", electronicCategory, javaBook);
        CategorizedItem electronicTransistorBook = new CategorizedItem("user2", electronicCategory, transistorBook);
        CategorizedItem booksTransistorBook = new CategorizedItem("user3", bookCategory, transistorBook);
        CategorizedItem booksTheThreePigs = new CategorizedItem("user3", bookCategory, theThreePigs);
        CategorizedItem electronicAppleComputer = new CategorizedItem("user3", electronicCategory, appleComputer);

        categorizedItemRepository.save(electronicJavaBook);

//        categorizedItemRepository.delete(electronicJavaBook);
    }
    @Test
    void doNothing() {

    }

    @Test
    void saveWithCascadePersist() {
        Category electronicCategory = new Category("electronic");
        Item javaBook = new Item("java book");
        itemRepository.save(javaBook);
        categoryRepository.save(electronicCategory);
//        electronicCategory.addItem("Carl", javaBook);
        categoryRepository.save(electronicCategory);


    }

    @Test
    void saveWithCascadePersistV2() {

            Category electronicCategory = new Category("electronic");
            categoryRepository.save(electronicCategory); // Save category first

            Item javaBook = new Item("java book");
            itemRepository.save(javaBook);

            CategorizedItem categorizedItem = new CategorizedItem("carl", electronicCategory, javaBook);
//            electronicCategory.addItem("Carl", javaBook);
            electronicCategory.addCategorizedItem(categorizedItem);

            categoryRepository.save(electronicCategory);

    }

    @Test
    void saveWithPersistInCategorizedItem() {
        Category electronicCategory = new Category("electronic");
        Item javaBook = new Item("java book");
        CategorizedItem categorizedItem = new CategorizedItem("carl", electronicCategory, javaBook);
        categorizedItemRepository.save(categorizedItem);
    }


}
