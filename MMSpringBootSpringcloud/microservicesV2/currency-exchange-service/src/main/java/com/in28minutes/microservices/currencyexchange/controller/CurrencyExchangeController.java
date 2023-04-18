package com.in28minutes.microservices.currencyexchange.controller;

import com.in28minutes.microservices.currencyexchange.model.CurrencyExchange;
import com.in28minutes.microservices.currencyexchange.service.CurrencyExchangeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

    Logger logger = LoggerFactory.getLogger(CurrencyExchangeController.class);
    private CurrencyExchangeService currencyExchangeService;

    private Environment environment;

    public CurrencyExchangeController(CurrencyExchangeService currencyExchangeService, Environment environment) {
        this.currencyExchangeService = currencyExchangeService;
        this.environment = environment;
    }

    @GetMapping("/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyExchange obtainCurrencyExchange(@PathVariable String fromCurrency, @PathVariable String toCurrency) {
        logger.info("calling to obtainCurrencyExchange with values {}, {}", fromCurrency, toCurrency);
        CurrencyExchange currencyExchange = this.currencyExchangeService.
                obtainCurrencyExchange(fromCurrency, toCurrency)
                .orElseThrow(() -> new NoSuchElementException("there's no currency exchange between " + fromCurrency + " to " + toCurrency));
        currencyExchange.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchange;
    }


}
