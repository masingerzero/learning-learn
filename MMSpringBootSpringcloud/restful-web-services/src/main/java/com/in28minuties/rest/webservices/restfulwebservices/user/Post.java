package com.in28minuties.rest.webservices.restfulwebservices.user;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private int id;
    @Size(min = 10)
    private String description;
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }
}
