package org.masingerzero.modernjava.chapter10;

import org.masingerzero.modernjava.model.Order;
import org.masingerzero.modernjava.model.Stock;
import org.masingerzero.modernjava.model.Trade;

public class NestedFunctionOrderBuilder {
//    Order order = order("BigBank",
//            buy(80,
//                    stock("IBM", on("NYSE")),
//                    at(125.00)),
//            sell(50,
//                    stock("GOOGLE", on("NASDAQ")),
//                    at(375.00))
//    );

    private Order order;

    private NestedFunctionOrderBuilder(String customer) {
        order = new Order();
        order.setCustomer(customer);
    }



    public static Order order(String customer, Trade... trades) {
        NestedFunctionOrderBuilder builder = new NestedFunctionOrderBuilder(customer);
        for (Trade trade : trades) {
            builder.order.addTrade(trade);
        }
        return builder.order;
    }

    public static String on(String market) {
        return market;
    }

    public static Stock stock(String symbol, String market) {
        Stock stock = new Stock();
        stock.setSymbol(symbol);
        stock.setMarket(market);
        return stock;
    }

    public static double at(double price) {
        return price;
    }

    public static Trade buy(int quantity, Stock stock, double price) {
        return buildTrade(quantity, stock, price, Trade.Type.BUY);
    }

    public static Trade sell(int quantity, Stock stock, double price) {
        return buildTrade(quantity, stock, price, Trade.Type.SELL);
    }

    private static  Trade buildTrade(int quantity, Stock stock, double price, Trade.Type type) {
        Trade trade = new Trade();
        trade.setType(type);
        trade.setStock(stock);
        trade.setPrice(price);
        trade.setQuantity(quantity);
        return trade;
    }

}
