package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.NONE)
@Entity
public class Category {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    private Long id;

    private String name;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @Setter(AccessLevel.NONE)
    @ManyToMany(cascade = {CascadeType.PERSIST})
    @JoinTable(name = "CATEGORY_ITEM", joinColumns = @JoinColumn(name = "CATEGORY_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
    @OrderColumn(name = "ITEM_ORDER")
    private Set<Item> items = new HashSet<>();

    //    @EqualsAndHashCode.Exclude
//    @ToString.Exclude
//    @Setter(AccessLevel.NONE)
//    @ManyToMany(cascade = {CascadeType.PERSIST})
//    @JoinTable(name = "CATEGORY_ITEM", joinColumns = @JoinColumn(name = "CATEGORY_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_ID"))
//    @OrderColumn(name = "ITEM_ORDER")
//    private List<Item> items = new ArrayList<>();@EqualsAndHashCode.Exclude
//
//    @ToString.Exclude
//    @Setter(AccessLevel.NONE)
//    @ManyToMany(cascade = {CascadeType.PERSIST})
//    @JoinTable(name = "CATEGORY_ITEM",
//            joinColumns = @JoinColumn(name = "CATEGORY_ID"), inverseJoinColumns = @JoinColumn(name = "ITEM_ID"),
//            uniqueConstraints = @UniqueConstraint(columnNames = {"CATEGORY_ID", "ITEM_ID"}))
//    @OrderColumn(name = "ITEM_ORDER")
//    private List<Item> items = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public void addItem(Item item) {
        items.add(item);
    }


}
