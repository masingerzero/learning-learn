package com.in28minutes.microservices.currencyexchange.respository;

import com.in28minutes.microservices.currencyexchange.model.CurrencyExchange;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {
    Optional<CurrencyExchange> findCurrencyByFromCurrencyAndToCurrency(String fromCurrency, String toCurrency);
}
