package com.in28minutes.microservices.currencyconversion.controller;

import com.in28minutes.microservices.currencyconversion.beans.CurrencyConversion;
import com.in28minutes.microservices.currencyconversion.service.CurrencyConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("currency-conversion")
@RestController
public class CurrencyConversionController {

    private CurrencyConversionService currencyConversionService;

    public CurrencyConversionController(CurrencyConversionService currencyConversionService) {
        this.currencyConversionService = currencyConversionService;
    }

    @GetMapping("/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversion(@PathVariable String fromCurrency, @PathVariable String toCurrency, @PathVariable int quantity) {
        return currencyConversionService.calculateCurrencyConversion(fromCurrency, toCurrency, quantity);
    }


    @GetMapping("/feign/from/{fromCurrency}/to/{toCurrency}/quantity/{quantity}")
    public CurrencyConversion calculateCurrencyConversionFeign(@PathVariable String fromCurrency, @PathVariable String toCurrency, @PathVariable int quantity) {
        return currencyConversionService.calculateCurrencyConversionFeign(fromCurrency, toCurrency, quantity);
    }
}
