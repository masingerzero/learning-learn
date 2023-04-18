package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    private Long id;

    private String name;
    protected Item() {};

    public Item(String name) {
        this.name = name;
    }

    @MapKey(name = "id")
    @OneToMany(mappedBy = "item")
    private Map<Long, Bid> bids = new HashMap<>();

    public void addBid(Bid bid) {
        bids.put(bid.getId(), bid);
    }

    public Map<Long, Bid> getBids() {
        return Collections.unmodifiableMap(bids);
    }

    public Long getId() {
        return id;
    }
}