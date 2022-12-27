package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "ITEM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Item {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    @Getter
    private Long id;

    @Getter
    private String name;

    @ElementCollection
    @CollectionTable(name = "IMAGE")
    @MapKeyColumn(name = "TITLE")
    private Map<String, Image> images = new HashMap<>();

    public Item(String name) {
        this.name = name;
    }

    public void addImage(String title, Image image) {
        images.put(title, image);
    }

    public Map<String, Image> getImages() {
        return Collections.unmodifiableMap(images);
    }
}
