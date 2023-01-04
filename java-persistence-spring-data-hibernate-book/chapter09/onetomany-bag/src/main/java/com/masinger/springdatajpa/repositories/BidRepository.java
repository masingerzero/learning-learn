package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.Bid;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BidRepository extends JpaRepository<Bid, Long> {
}
