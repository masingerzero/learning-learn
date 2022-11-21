package com.masinger.springdatajpa.bagofstrings;

import com.masinger.springdatajpa.configuration.bagofstrings.SpringDataConfiguration;
import com.masinger.springdatajpa.model.setofstrings.Item;
import com.masinger.springdatajpa.repositories.setofstrings.ItemRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringDataConfiguration.class})
public class SpringDataJpaTest {



    @Test
    void storeLoadEntities() {

    }

}
