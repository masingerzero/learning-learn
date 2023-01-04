package com.masinger.springdatajpa.model;

import com.masinger.springdatajpa.Constants;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "BID")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class Bid {
    @Id
    @GeneratedValue(generator = Constants.GENERATOR)
    @Setter(AccessLevel.NONE)
    Long Id;

    @NotNull
    private BigDecimal amount;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID")
    Item item;

    public Bid(BigDecimal amount, Item item) {
        this.amount = amount;
        this.item = item;
    }
}
