package com.masinger.springdatajpa.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//@Data
@AllArgsConstructor
public class FileName {
    @Column(nullable = false)
    private String name;
}
