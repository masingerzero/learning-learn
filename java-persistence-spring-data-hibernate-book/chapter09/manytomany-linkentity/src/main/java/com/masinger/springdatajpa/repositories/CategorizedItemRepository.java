package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.CategorizedItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorizedItemRepository extends JpaRepository<CategorizedItem, CategorizedItem.Id> {
}