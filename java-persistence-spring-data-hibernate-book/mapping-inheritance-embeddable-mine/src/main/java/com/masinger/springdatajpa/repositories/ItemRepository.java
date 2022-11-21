package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
