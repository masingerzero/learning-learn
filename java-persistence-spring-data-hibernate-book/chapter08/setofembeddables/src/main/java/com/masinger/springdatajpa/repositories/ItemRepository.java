package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.Image;
import com.masinger.springdatajpa.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.lang.annotation.Native;
import java.util.Set;

public interface ItemRepository extends JpaRepository<Item, Long> {


    @Query("select i from Item i inner join fetch i.images where i.id=:id")
    Item findItemWithImages(@Param("id") Long id);



    @Query(value = "SELECT * FROM IMAGE WHERE ITEM_ID = ?1", nativeQuery = true)
    public Set<Image> findImagesNative(Long id);
}