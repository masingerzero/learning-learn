package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.CategorizedItem;
import com.masinger.springdatajpa.model.Category;
import com.masinger.springdatajpa.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("select c from Category c join c.categorizedItems ci where ci.item = :item")
    List<Category> findCategoryWithCategorizedItems(@Param("item") Item item);


}