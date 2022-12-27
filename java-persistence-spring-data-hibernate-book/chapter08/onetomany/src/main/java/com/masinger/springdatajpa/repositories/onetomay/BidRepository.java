package com.masinger.springdatajpa.repositories.onetomay;

import com.masinger.springdatajpa.model.onetomany.Bid;
import com.masinger.springdatajpa.model.onetomany.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface BidRepository extends JpaRepository<Bid, Long> {
    Set<Bid> findByItem(Item item);
}
