package com.masinger.springdatajpa.model.setofstrings;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    Long Id;
    private String name;

    @ElementCollection
    @CollectionTable (
            name = "IMAGE",
            joinColumns = @JoinColumn(name = "ITEM_ID")
    )
    @Column(name = "FILENAME")
    private Set<String> images = new HashSet<>();

    protected Item() {};


    public Item(String name) {
        this.name = name;
    }

    public void add(String image) {
        this.images.add(image);
    }

    public Set<String> getImages() {
        return Collections.unmodifiableSet(images);
    }

    public Long getId() {
        return Id;
    }
}
