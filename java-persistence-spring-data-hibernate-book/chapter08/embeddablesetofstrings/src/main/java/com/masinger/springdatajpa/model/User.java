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
@Table(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class User {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;

    private Address address;

    public User(String name) {
        this.name = name;
    }
}
