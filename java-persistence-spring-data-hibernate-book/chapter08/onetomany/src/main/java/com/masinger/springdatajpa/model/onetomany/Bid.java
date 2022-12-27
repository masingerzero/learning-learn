package com.masinger.springdatajpa.model.onetomany;

import com.masinger.springdatajpa.Constants;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Bid {
    @Id
    @GeneratedValue(generator = Constants.ID_GENERATOR)
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ITEM_ID", nullable = false)
    private Item item;

    private BigDecimal amount;

    public Bid(BigDecimal amount, Item item) {
        this.item = item;
        this.amount = amount;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Bid bid = (Bid) o;
        return id != null && Objects.equals(id, bid.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
