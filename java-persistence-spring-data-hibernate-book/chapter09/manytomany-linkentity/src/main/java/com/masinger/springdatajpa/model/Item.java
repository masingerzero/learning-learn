package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ITEM")
public class Item {

    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "item")
    private Set<CategorizedItem> categorizedItems = new HashSet<>();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<CategorizedItem> getCategorizedItems() {
        return Collections.unmodifiableSet(categorizedItems);
    }

    public void addCategorizedItem(CategorizedItem categorizedItem) {
        categorizedItems.add(categorizedItem);
    }
}