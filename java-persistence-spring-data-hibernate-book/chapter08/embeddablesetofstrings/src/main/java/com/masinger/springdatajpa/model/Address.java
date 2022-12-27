package com.masinger.springdatajpa.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class Address {
    @NotNull
    @Column(nullable = false)
    private String street;

    @NotNull
    @Column(nullable = false, length = 5)
    private String zipcode;

    @NotNull
    @Column(nullable = false)
    private String city;

    public Address(String street, String zipcode, String city) {
        this.street = street;
        this.zipcode = zipcode;
        this.city = city;
    }

    @Setter(AccessLevel.NONE)
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(
            name = "CONTACT",
            joinColumns = @JoinColumn(
                    name = "USER_ID"
            )
    )
    @Column(name = "name", nullable = false)
    private Set<String> contacts = new HashSet<>();

    public Set<String> getContacts() {
        return Collections.unmodifiableSet(contacts);
    }

    public void addContact(String contact) {
        this.contacts.add(contact);
    }
}
