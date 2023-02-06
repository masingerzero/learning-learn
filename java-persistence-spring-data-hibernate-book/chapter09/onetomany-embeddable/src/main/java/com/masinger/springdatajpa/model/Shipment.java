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
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@Entity
@Table(name = "SHIPMENT")
public class Shipment {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    private Long id;

    private Date createdOn;

    public Shipment(Date createdOn) {
        this.createdOn = createdOn;
    }
}
