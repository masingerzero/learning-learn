package com.in28minuties.rest.webservices.restfulwebservices.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private int id;

    @JsonIgnore
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }
}
