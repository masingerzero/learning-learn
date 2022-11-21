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
    @MapKeyColumn(name = "FILENAME")
    @Column(name = "USER_IMAGE_NAME")
    @org.hibernate.annotations.SortComparator(ReverseStringComparator.class)
    private SortedMap<String, String> images = new TreeMap<>();

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

    public static class ReverseStringComparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return o2.compareTo(o1);
        }
    }
}
