package com.in28minutes.microservices.currencyexchange.controller;

import com.in28minutes.microservices.currencyexchange.model.CurrencyExchange;
import com.in28minutes.microservices.currencyexchange.service.CurrencyExchangeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    private CurrencyExchangeService currencyExchangeService;

    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService) {
        this.currencyExchangeService = currencyExchangeService;
    }

    @GetMapping("/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyExchange obtainCurrencyExchange(@PathVariable String fromCurrency, @PathVariable String toCurrency) {
        return this.currencyExchangeService.
                obtainCurrencyExchange(fromCurrency, toCurrency)
                .orElseThrow();
    }


}
