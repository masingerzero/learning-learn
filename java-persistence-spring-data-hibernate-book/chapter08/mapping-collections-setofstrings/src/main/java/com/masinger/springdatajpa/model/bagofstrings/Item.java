package com.masinger.springdatajpa.model.bagofstrings;

import com.masinger.springdatajpa.Constants;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
public class Item {

    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    private Long Id;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @Column(name = "FILENAME")
    @org.hibernate.annotations.GenericGenerator(name = "sequence_gen", strategy = "sequence")
    @org.hibernate.annotations.CollectionId(
            column = @Column(name = "IMAGE_ID"),
            type = @org.hibernate.annotations.Type(type = "long"),
            generator = "sequence_generator"
    )
    private Collection<String> images = new ArrayList<>();

    protected Item() {
    }

    public void addImage(String image) {
        images.add(image);
    }

    public Collection<String> getImages() {
        return Collections.unmodifiableCollection(images);
    }
}
