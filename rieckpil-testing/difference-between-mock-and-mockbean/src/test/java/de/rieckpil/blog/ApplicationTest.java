package de.rieckpil.blog;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Random;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApplicationTest {

    @Autowired
    private StockApiClient stockApiClient;

    @MockBean
    private ExpensiveRealtimeStockApiClient expensiveRealtimeStockApiClient;

    @Test
    void contextLoadsWithAllBeans() {
        Mockito.when(expensiveRealtimeStockApiClient.getLatestStockPrice("CCC"))
                .thenReturn(BigDecimal.TEN);

    }
}
