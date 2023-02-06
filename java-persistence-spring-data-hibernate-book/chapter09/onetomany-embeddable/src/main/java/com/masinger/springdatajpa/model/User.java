package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.*;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@Table(name = "USERS")
public class User {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    Long id;

    private String name;

    @Embedded
    private Address address;

    public User(String name, Address address) {
        this.name = name;
        this.address = address;
    }
}
