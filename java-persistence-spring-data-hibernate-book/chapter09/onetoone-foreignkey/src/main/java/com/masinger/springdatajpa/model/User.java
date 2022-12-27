package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.*;

import javax.persistence.*;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.*;
import static lombok.AccessLevel.*;

@Entity
@Table(name = "USERS")
@NoArgsConstructor(access = PACKAGE)
@Data
public class User {
    @Setter(value = NONE)
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    Long id;
    private String firstName;
    private String lastName;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(fetch = LAZY,
            optional = false,
            cascade = PERSIST)
    @JoinColumn(unique = true)
    private Address shippingAddress;

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

}
