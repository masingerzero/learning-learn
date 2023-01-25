package com.in28minutes.microservices.currencyexchange.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class CurrencyExchange {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(generator = "ID_GENERATOR")
    private Long id;
    private String fromCurrency;

    private String toCurrency;

    private BigDecimal conversionMultiple;

    public CurrencyExchange(String fromCurrency, String toCurrency, BigDecimal conversionMultiple) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.conversionMultiple = conversionMultiple;
    }
}
