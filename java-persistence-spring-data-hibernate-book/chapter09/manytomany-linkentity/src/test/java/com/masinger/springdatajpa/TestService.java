package com.masinger.springdatajpa;

import com.masinger.springdatajpa.model.CategorizedItem;
import com.masinger.springdatajpa.model.Category;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.CategorizedItemRepository;
import com.masinger.springdatajpa.repositories.CategoryRepository;
import com.masinger.springdatajpa.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TestService {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategorizedItemRepository categorizedItemRepository;

    @Transactional
    public void storeAndLoadEntities() {
        Category electronicCategory = new Category("electronic");
        Category bookCategory = new Category("books");
        Item javaBook = new Item("java book");
        Item transistorBook = new Item("transistor documentation");
        Item appleComputer = new Item("Apple computer");
        Item theThreePigs = new Item("the three pigs");
        CategorizedItem electronicJavaBook = new CategorizedItem("user1", electronicCategory, javaBook);
        CategorizedItem electronicTransistorBook = new CategorizedItem("user2", electronicCategory, transistorBook);
        CategorizedItem booksTransistorBook = new CategorizedItem("user3", bookCategory, transistorBook);
        CategorizedItem booksTheThreePigs = new CategorizedItem("user3", bookCategory, theThreePigs);
        CategorizedItem electronicAppleComputer = new CategorizedItem("user3", electronicCategory, appleComputer);

        categoryRepository.save(electronicCategory);
        itemRepository.save(javaBook);
        categorizedItemRepository.save(electronicJavaBook);
    }

    @Transactional
    public void storeWithCascadePersist() {
        Category electronicCategory = new Category("electronic");
        Item javaBook = new Item("java book");
        itemRepository.save(javaBook);
        categoryRepository.save(electronicCategory);
//        electronicCategory.addItem("Carl", javaBook);
        categoryRepository.save(electronicCategory);
    }
}
