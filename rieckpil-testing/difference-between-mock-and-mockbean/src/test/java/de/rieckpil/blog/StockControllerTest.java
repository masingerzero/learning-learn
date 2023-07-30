package de.rieckpil.blog;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

@WebMvcTest(StockController.class)
@Import({StockService.class, StockApiClient.class})

public class StockControllerTest {

////    @MockBean
//    @Autowired
    private StockService stockService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void loadContext() {

    }

    @Test
    void test() throws Exception {
        Mockito.when(stockService
                .getLatestPrice("CCC")).thenReturn(BigDecimal.valueOf(100));

        mockMvc.perform(MockMvcRequestBuilders.get("/api/stocks?stockCode=CCC"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
