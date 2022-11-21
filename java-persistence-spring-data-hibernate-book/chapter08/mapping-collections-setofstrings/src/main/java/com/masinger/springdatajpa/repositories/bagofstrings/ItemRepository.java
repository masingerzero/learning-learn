package com.masinger.springdatajpa.repositories.bagofstrings;

import com.masinger.springdatajpa.model.bagofstrings.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    
}
