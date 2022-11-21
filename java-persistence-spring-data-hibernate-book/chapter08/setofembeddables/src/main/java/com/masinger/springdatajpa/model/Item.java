package com.masinger.springdatajpa.model;


import com.masinger.springdatajpa.Constants;

import javax.persistence.*;
import java.util.*;

@Entity
public class Item {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    private Long id;


    private String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @AttributeOverride(
            name = "filename",
            column = @Column(name = "FNAME", nullable = false)
    )
    private Set<Image> images = new HashSet<>();

    public Item(String name) {
        this.name = name;
    }

    protected Item() {
    }

    public Long getId() {
        return id;
    }

    public void addImage(Image image) {
        this.images.add(image);
    }

    public Set<Image> getImages() {
        return Collections.unmodifiableSet(images);
    }
}
