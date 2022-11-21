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
    @Column(name = "FILENAME")
    @OrderBy("FILENAME desc")
    private Set<String> images = new HashSet<>();



    protected Item() {}

    public Item(String name) {
        this.name = name;
    }

    public void addImage(String image) {
        this.images.add(image);
    }

    public Set<String> getImages() {
        return Collections.unmodifiableSet(this.images);
    }

    public Long getId() {
        return id;
    }

    public static class ReverseStringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
}
