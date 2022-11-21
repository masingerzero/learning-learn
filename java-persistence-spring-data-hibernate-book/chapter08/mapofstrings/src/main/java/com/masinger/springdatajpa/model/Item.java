package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Entity
public class Item {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @MapKeyColumn(name = "FILENAME")
    @Column(name = "USER_IMAGE_NAME")
    private Map<String, String> images = new HashMap<>();

    protected Item() {}

    public Item(String name) {
        this.name = name;
    }

    public void addImage(String filename, String userImageName) {
        this.images.put(filename, userImageName);
    }

    public Map<String, String> getImages() {
        return Collections.unmodifiableMap(this.images);
    }

    public Long getId() {
        return id;
    }
}
