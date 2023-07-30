package de.rieckpil.blog;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

@ExtendWith(MockitoExtension.class)
public class StockServiceTest {


    @Mock
    StockApiClient stockApiClient;
    @InjectMocks
    StockService cut;

    @Test
    void shouldCallStockApiClientIfStockCodeNotInTechCompanies() {
        BigDecimal clientReturn = BigDecimal.valueOf(100);
        Mockito.when(
                stockApiClient.getLatestStockPrice("CCC"))
                .thenReturn(clientReturn);
        BigDecimal result = cut.getLatestPrice("CCC");
        Mockito.verify(stockApiClient).getLatestStockPrice("CCC");
        Assertions.assertEquals(clientReturn, result);
    }

    @Test
    void shouldReturnDefaultPriceWhenClientThrowsException() {
        Mockito.when(
                cut.getLatestPrice("AMZN")
        ).thenThrow(new RuntimeException("Remote System Down!!!"));

        BigDecimal result = cut.getLatestPrice("AMZN");
        Assertions.assertEquals(BigDecimal.ZERO, result);
    }

}
