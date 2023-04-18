package com.in28minutes.microservices.currencyexchange.controller;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CircuitBreakerController {
    Logger logger = LoggerFactory.getLogger(CircuitBreakerController.class);

    @GetMapping("/sample-api")
//    @Retry(name= "sample-api", fallbackMethod = "hardcodedResponse")
//    @CircuitBreaker(name = "xxx", fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name = "default", fallbackMethod = "hardcodedResponse")
    @Bulkhead(name = "sample-api")
    public String sampleApi() throws Exception {
        logger.info("calling to sampleApi()");
        Thread.sleep(1000);
//        return new RestTemplate().getForEntity("http://localhost:8080/dummy-service", String.class).getBody();
        return "SampleApi";

    }


    @GetMapping("/sample-api1")
//    @Retry(name= "sample-api", fallbackMethod = "hardcodedResponse")
//    @CircuitBreaker(name = "xxx", fallbackMethod = "hardcodedResponse")
//    @RateLimiter(name = "simple-api1", fallbackMethod = "hardcodedResponse")
    public String sampleApi1() {
        logger.info("calling to sampleApli_1()");
//        return new RestTemplate().getForEntity("http://localhost:8080/dummy-service", String.class).getBody();
        return "sampleApi_01";
    }


    public String hardcodedResponse(Exception exception) {
        logger.info("EXCEPTION handled!!! by hardcodedResponse");

//        logger.info("exception.getClass() = " + exception.getClass());
//        logger.info("exception LocalizedMessage : " + exception.getLocalizedMessage());
        return "fallback method, threads = " + Thread.activeCount();
    }
}
