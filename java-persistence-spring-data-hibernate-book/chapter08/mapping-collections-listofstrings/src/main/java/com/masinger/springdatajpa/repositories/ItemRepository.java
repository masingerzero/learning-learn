package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select i from Item i inner join fetch i.images")
    List<Item> fetchAllItems() ;
}
