package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}