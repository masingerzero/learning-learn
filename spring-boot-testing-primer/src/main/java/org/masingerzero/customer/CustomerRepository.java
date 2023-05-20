package org.masingerzero.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CustomerRepository extends JpaRepository<Customer, Long> {


    @Query(value = "SELECT * FROM CUSTOMER ORDER BY JOINED_AT ASC LIMIT 1", nativeQuery = true)
    Customer findEarliestJoinedCustomer();
}