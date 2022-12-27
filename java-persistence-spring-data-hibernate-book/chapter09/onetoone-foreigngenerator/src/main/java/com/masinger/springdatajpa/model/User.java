package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    Long id;

    private String name;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(
            mappedBy = "user",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    Address shippingAddress;

    public User(String name) {
        this.name = name;
    }
}
