package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor(access = AccessLevel.NONE)
@Entity
public class Item {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    private Long id;

    private String name;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @Setter(AccessLevel.NONE)
    @ManyToMany(mappedBy = "items")
    private Set<Category> categories = new HashSet<>();

    public Item(String name) {
        this.name = name;
    }

}
