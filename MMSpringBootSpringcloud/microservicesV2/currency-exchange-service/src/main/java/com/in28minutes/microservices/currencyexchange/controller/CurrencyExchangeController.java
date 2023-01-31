package com.in28minutes.microservices.currencyexchange.controller;

import com.in28minutes.microservices.currencyexchange.model.CurrencyExchange;
import com.in28minutes.microservices.currencyexchange.service.CurrencyExchangeService;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    private CurrencyExchangeService currencyExchangeService;

    private Environment environment;

    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService, Environment environment) {
        this.currencyExchangeService = currencyExchangeService;
        this.environment = environment;
    }

    @GetMapping("/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyExchange obtainCurrencyExchange(@PathVariable String fromCurrency, @PathVariable String toCurrency) {
        CurrencyExchange currencyExchange = this.currencyExchangeService.
                obtainCurrencyExchange(fromCurrency, toCurrency)
                .orElseThrow(() -> new NoSuchElementException("there's no currency exchange between " + fromCurrency + " to " + toCurrency));
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }


}
