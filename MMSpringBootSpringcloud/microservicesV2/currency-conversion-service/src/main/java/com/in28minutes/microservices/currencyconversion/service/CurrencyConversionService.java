package com.in28minutes.microservices.currencyconversion.service;

import com.in28minutes.microservices.currencyconversion.beans.CurrencyConversion;
import com.in28minutes.microservices.currencyconversion.integration.CurrencyExchangeProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyConversionService {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private CurrencyExchangeProxy currencyExchangeProxy;
    public CurrencyConversion calculateCurrencyConversion(String fromCurrency, String toCurrency, int quantity) {
        String url = "http://localhost:8000/currency-exchange/from/{fromCurrency}/to/{toCurrency}";
        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("fromCurrency", fromCurrency);
        uriVariables.put("toCurrency", toCurrency);
        CurrencyConversion currencyConversion = restTemplate.getForEntity(url, CurrencyConversion.class, uriVariables).getBody();
        currencyConversion.setQuantity(quantity);

        return currencyConversion;
    }
    public CurrencyConversion   calculateCurrencyConversionFeign(String fromCurrency, String toCurrency, int quantity) {
        CurrencyConversion currencyConversion = currencyExchangeProxy.obtainCurrencyExchange(fromCurrency, toCurrency);
        currencyConversion.setQuantity(quantity);
        return currencyConversion;
    }
}