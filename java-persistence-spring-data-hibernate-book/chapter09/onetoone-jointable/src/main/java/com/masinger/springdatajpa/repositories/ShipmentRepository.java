package com.masinger.springdatajpa.repositories;

import com.masinger.springdatajpa.model.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ShipmentRepository extends JpaRepository<Shipment, Long> {
    @Query("select s from Shipment s inner join fetch s.auction where s.id = :id")
    Shipment findByIdWithAuction(@Param("id") Long id);
}
