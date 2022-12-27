package org.masingerzero.modernjava.chapter10;

import org.junit.jupiter.api.Test;
import org.masingerzero.modernjava.model.Order;
import org.masingerzero.modernjava.model.Stock;
import org.masingerzero.modernjava.model.Trade;

public class Chapter10Test {

//    Order order =
//            forCustomer("BigBank",
//                    buy(t -> t.quantity(80)
//                            .stock("IBM")
//                            .on("NYSE")
//                            .at(125.00)),
//                    sell(t -> t.quantity(50)
//                            .stock("GOOGLE")
//                            .on("NASDAQ")
//                            .at(375.00)));
    @Test
    public void testReadKernel() {

        Order expectedOrder = new Order("BigBank");
        Stock stock1 = new Stock("IBM", "NYSE");
        Trade trade1 = new Trade(Trade.Type.BUY, stock1, 80, 125.00);
        expectedOrder.addTrade(trade1);

        Stock stock2 = new Stock("GOOGLE", "NASDAQ");
        Trade trade2 = new Trade(Trade.Type.SELL, stock2, 50, 375.00);
        expectedOrder.addTrade(trade2);




    }

}



