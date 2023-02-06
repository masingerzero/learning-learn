package com.masinger.springdatajpa.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {
    @NotNull
    @Column(nullable = false)
    private String street;
    @NotNull
    @Column(nullable = false)
    private String zipCode;
    @NotNull
    @Column(nullable = false)
    private String city;

//    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @Setter(AccessLevel.NONE)
//    @OneToMany
//    @JoinColumn(name = "DELIVERY_ADDRESS_USER_ID", nullable = false)
//    private Set<Shipment> deliveries = new HashSet<>();

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany
    @JoinTable(name = "DELIVERIES",
            joinColumns = @JoinColumn(name = "USER_ID"),
    inverseJoinColumns = @JoinColumn(name = "SHIPMENT_ID"))
    private Set<Shipment> deliveries = new HashSet<>();


    public Address(String street, String zipCode, String city) {
        this.street = street;
        this.zipCode = zipCode;
        this.city = city;
    }

   public void addShipment(Shipment shipment) {
        this.deliveries.add(shipment);

   }
}
