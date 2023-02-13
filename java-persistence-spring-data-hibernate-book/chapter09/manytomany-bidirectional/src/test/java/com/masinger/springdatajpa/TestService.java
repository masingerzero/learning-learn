package com.masinger.springdatajpa;

import com.masinger.springdatajpa.model.Category;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TestService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional
    public void storeAndLoadEntities() {
        Category someCategory = new Category("someCategory");
        Category anotherCategory = new Category("anotherCategory");
        Item item1 = new Item("item1");
        Item item2 = new Item("item2");
//        itemRepository.save(item1);
//        itemRepository.save(item2);
//
        someCategory.addItem(item1);
        someCategory.addItem(item2);
        someCategory.addItem(item1);
        anotherCategory.addItem(item1);
        anotherCategory.addItem(item2);
        categoryRepository.save(someCategory);
        categoryRepository.save(anotherCategory);
    }
}
