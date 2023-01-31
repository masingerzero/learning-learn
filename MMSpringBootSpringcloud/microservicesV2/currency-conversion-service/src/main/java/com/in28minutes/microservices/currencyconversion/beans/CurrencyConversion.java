package com.in28minutes.microservices.currencyconversion.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyConversion {

    private Long id;
    private String fromCurrency;

    private String toCurrency;

    private int quantity;
    private BigDecimal conversionMultiple;


    private BigDecimal totalCalculatedAmount;

    private String environment;


    public BigDecimal getTotalCalculatedAmount() {
        return conversionMultiple.multiply(BigDecimal.valueOf(quantity));
    }
}
