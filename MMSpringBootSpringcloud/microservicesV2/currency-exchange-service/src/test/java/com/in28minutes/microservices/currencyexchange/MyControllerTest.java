package com.in28minutes.microservices.currencyexchange;

import io.github.resilience4j.bulkhead.BulkheadFullException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MyControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test(expected = BulkheadFullException.class)
    public void testBulkhead() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<ResponseEntity<String>>> results = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            results.add(executorService.submit(() -> restTemplate.getForEntity("/sample-api", String.class)));
        }
        for (Future<ResponseEntity<String>> result : results) {
            result.get();
        }
    }
}

