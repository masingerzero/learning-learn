package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@Table(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    @Setter(AccessLevel.NONE)
    Long Id;

    @NotNull
    private String name;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "item", cascade = CascadeType.PERSIST)
    Collection<Bid> bids = new ArrayList<>();

    public Item(String name) {
        this.name = name;
    }

    public void addBid(Bid bid) {
        this.bids.add(bid);
    }
}
