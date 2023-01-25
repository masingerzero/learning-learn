package com.masinger.springdatajpa;

import com.masinger.springdatajpa.configuration.SpringDataConfiguration;
import com.masinger.springdatajpa.model.Item;
import com.masinger.springdatajpa.model.User;
import com.masinger.springdatajpa.repositories.ItemRepository;
import com.masinger.springdatajpa.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    UserRepository userRepository;

    @Test
    void storeLoadEntities() {
        User user = new User("Tom");
        Item item = new Item("item 1");
        Item anotherItem = new Item("another item");
        item.setBuyer(user);
        anotherItem.setBuyer(user);
        user.addItem(item);
        user.addItem(anotherItem);
        userRepository.save(user);
        itemRepository.save(item);
        itemRepository.save(anotherItem);



    }
}
