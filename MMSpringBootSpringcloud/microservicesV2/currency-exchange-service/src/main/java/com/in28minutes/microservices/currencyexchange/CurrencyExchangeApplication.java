package com.in28minutes.microservices.currencyexchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CurrencyExchangeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CurrencyExchangeApplication.class, args);
    }


//	@Bean
//	public CommandLineRunner createData(CurrencyExchangeRepository repo) {
//		return args -> {
//			CurrencyExchange currencyExchange = new CurrencyExchange("US", "INR", BigDecimal.valueOf(65.00) );
//			repo.save(currencyExchange);
//		};
//	}
}
