package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
}