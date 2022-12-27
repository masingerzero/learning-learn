package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@Table(name = "SHIPMENT")
public class Shipment {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    Long id;

    private String status;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinTable(name = "ITEM_SHIPMENT",
            joinColumns = {@JoinColumn(name = "SHIPMENT_ID")},
    inverseJoinColumns = {@JoinColumn(name = "ITEM_ID", nullable = false, unique = true)})
    private Item auction;
    public Shipment(String status, Item item) {
        this.status = status;
        this.auction = item;
    }


}
