package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Item {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    private Long Id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @OrderColumn
    @Column(name = "FILENAME")
    List<String> images = new ArrayList<>();

    protected Item() {
    }

    ;

    public Item(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void addImage(String image) {
        images.add(image);
    }

    public List<String> getImages() {
        return Collections.unmodifiableList(images);
    }
}
