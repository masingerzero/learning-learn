package org.masingerzero.modernjava.chapter10;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.masingerzero.modernjava.chapter10.TaxCalculator.Tax;
import org.masingerzero.modernjava.model.Order;
import org.masingerzero.modernjava.model.Stock;
import org.masingerzero.modernjava.model.Trade;

import static org.masingerzero.modernjava.chapter10.MethodChainingOrderBuilder.forCustomer;
import static org.masingerzero.modernjava.chapter10.TaxCalculatorV2.Tax.*;


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

        Order order = forCustomer("BigBank")
                .buy(80)
                .stock("IBM")
                .on("NYSE")
                .at(125.00)
                .sell(50)
                .stock("GOOGLE")
                .on("NASDAQ")
                .at(375.00)
                .end();

//        Assertions.assertEquals(expectedOrder, order);

        double expectedTax = ((order.getValue() * 1.1) * 1.3) * 1.05;
        double orderPriceWithTaxes = TaxCalculatorV2.calculateTaxes(order, REGIONAL, GENERAL, SURCHARGE);
//        double totalOrderWithTaxes = new TaxCalculatorV3()
//                .with(value -> value * 1.1)
//                .with(value -> value * 1.3)
//                .with(value -> value * 1.05)
//                .calculate(order);

//        double orderPriceWithTaxes = new TaxCalculator()
//                .with(Tax::regional)
//                .with(Tax::general)
//                .with(Tax::surcharge)
//                .calculate(order);
//
//
        Assertions.assertEquals(expectedTax, orderPriceWithTaxes);
//
        System.out.println(orderPriceWithTaxes);


    }

}



