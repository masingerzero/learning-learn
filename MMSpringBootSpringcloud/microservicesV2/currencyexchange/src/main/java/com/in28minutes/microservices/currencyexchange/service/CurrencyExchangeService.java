package com.in28minutes.microservices.currencyexchange.service;

import com.in28minutes.microservices.currencyexchange.model.CurrencyExchange;
import com.in28minutes.microservices.currencyexchange.respository.CurrencyExchangeRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CurrencyExchangeService {
    private CurrencyExchangeRepository currencyExchangeRepository;

    public CurrencyExchangeService(CurrencyExchangeRepository currencyExchangeRepository) {
        this.currencyExchangeRepository = currencyExchangeRepository;
    }

    public Optional<CurrencyExchange> obtainCurrencyExchange(String fromCurrency, String toCurrency) {
        return this.currencyExchangeRepository.findCurrencyByFromCurrencyAndToCurrency(fromCurrency, toCurrency);
    }
}
