package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.BillingDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingDetailsRepository<T extends BillingDetails, ID> extends JpaRepository<T, ID> {
    public List<T> findByOwner(String owner);

}
