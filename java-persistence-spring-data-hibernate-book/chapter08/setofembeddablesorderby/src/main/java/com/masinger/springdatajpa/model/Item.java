package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @OrderBy("filename DESC, width DESC")
    private Set<Image> images = new LinkedHashSet<>();

    protected Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public void addImage(Image image) {
        this.images.add(image);
    }

    public Long getId() {
        return id;
    }

    public Set<Image> getImages() {
        return Collections.unmodifiableSet(images);
    }
}
