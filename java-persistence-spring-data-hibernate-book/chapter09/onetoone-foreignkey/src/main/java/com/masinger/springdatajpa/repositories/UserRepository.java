package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.User;
import org.hibernate.annotations.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u From User u inner join fetch u.shippingAddress where u.id = :id")
    User findUserWithSippingAddress(@Param("id") Long id);
}
