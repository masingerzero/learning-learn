package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.*;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    @Query("select i from Item i inner join fetch i.images where i.id = :id")
    public Item getItemById(@Param("id") Long id);

    @Query("select i from Item i inner join fetch i.images")
    public List<Item> getAllItems();

    @Query(value = "SELECT FILENAME FROM IMAGE WHERE ITEM_ID = ?1", nativeQuery = true)
    public List<String> getImagesFromItemId(Long id);
}
