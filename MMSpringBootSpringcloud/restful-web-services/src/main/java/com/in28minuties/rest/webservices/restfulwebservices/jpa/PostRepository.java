package com.in28minuties.rest.webservices.restfulwebservices.jpa;

import com.in28minuties.rest.webservices.restfulwebservices.user.Post;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
