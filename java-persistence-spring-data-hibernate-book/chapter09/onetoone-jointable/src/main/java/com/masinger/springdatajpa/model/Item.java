package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ITEM")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class Item {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    @Setter(AccessLevel.NONE)
    Long id;

    private String name;

    public Item(String name) {
        this.name = name;
    }

}
