package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface AddressRepository extends JpaRepository<Address, Long> {
}