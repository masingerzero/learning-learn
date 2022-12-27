package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.*;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
@Data
@NoArgsConstructor(access = AccessLevel.NONE)
public class Address {
        @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = "addressKeyGenerator")
    @org.hibernate.annotations.GenericGenerator(
            name = "addressKeyGenerator",
            strategy = "foreign",
            parameters = @Parameter(
                    name = "property",
                    value = "user"

            )
    )
//    @Id
//    @GeneratedValue(generator = Constants.GENERATOR)
    Long id;

    private String street;

    private String zipcode;

    private String city;
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToOne(optional = false)
    @PrimaryKeyJoinColumn
    User user;

    public Address(String street, String zipcode, String city, User user) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
        this.user = user;
        user.setShippingAddress(this);
    }
}
