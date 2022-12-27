package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "ITEM")
public class Item {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @org.hibernate.annotations.GenericGenerator(name = "sequence_gen", strategy = "sequence" )
    @org.hibernate.annotations.CollectionId(
            column = @Column(name = "IMAGE_ID"),
            type = @org.hibernate.annotations.Type(
                    type = "long"

            ),
            generator = "sequence_gen"


    )
    private Collection<Image> images = new ArrayList<>();
    protected Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public void addImage(Image image) {
        images.add(image);
    }

    public String getName() {
        return name;
    }

    public Collection<Image> getImages() {
        return Collections.unmodifiableCollection(images);
    }
}
