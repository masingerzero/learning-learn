package com.masinger.springdatajpa.model;

import jdk.jfr.DataAmount;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Image {

    private String title;

    private int width;

    private int eight;


}
