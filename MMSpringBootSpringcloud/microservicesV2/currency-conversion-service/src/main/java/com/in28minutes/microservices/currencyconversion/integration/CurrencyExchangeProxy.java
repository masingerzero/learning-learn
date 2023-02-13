package com.in28minutes.microservices.currencyconversion.integration;

import com.in28minutes.microservices.currencyconversion.beans.CurrencyConversion;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange")
//@FeignClient(name = "currency-exchange", url = "localhost:8000")
public interface CurrencyExchangeProxy {
    @GetMapping("/currency-exchange/from/{fromCurrency}/to/{toCurrency}")
    public CurrencyConversion obtainCurrencyExchange(@PathVariable String fromCurrency, @PathVariable String toCurrency);
}
