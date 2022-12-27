package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
    private Map<FileName, Image> images = new HashMap<>();

    public Item(String name) {
        this.name = name;
    }

    public void addImage(FileName fileName, Image image) {
        images.put(fileName, image);
    }

    public Map<FileName, Image> getImages() {
        return Collections.unmodifiableMap(images);
    }
}
