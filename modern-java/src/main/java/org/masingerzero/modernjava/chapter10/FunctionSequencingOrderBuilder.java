package org.masingerzero.modernjava.chapter10;

import org.masingerzero.modernjava.model.Order;
import org.masingerzero.modernjava.model.Stock;
import org.masingerzero.modernjava.model.Trade;

import java.util.function.Consumer;

public class FunctionSequencingOrderBuilder {

    private Order order;

    private FunctionSequencingOrderBuilder() {
        this.order = new Order();
    }
    public static Order order(Consumer<FunctionSequencingOrderBuilder> orderBuilderConsumer) {
        FunctionSequencingOrderBuilder orderBuilder = new FunctionSequencingOrderBuilder();
        orderBuilderConsumer.accept(orderBuilder);
        return orderBuilder.order;
    }

    public void forCustomer(String customer) {
        order.setCustomer(customer);
    }

    public void buy(Consumer<TradeBuilder> tradeBuilderConsumer) {
        addTrade(Trade.Type.BUY, tradeBuilderConsumer);
    }

    public void sell(Consumer<TradeBuilder> tradeBuilderConsumer) {
        addTrade(Trade.Type.SELL, tradeBuilderConsumer);
    }

    private void addTrade(Trade.Type type, Consumer<TradeBuilder> tradeBuilderConsumer) {
        TradeBuilder tradeBuilder = new TradeBuilder();
        tradeBuilderConsumer.accept(tradeBuilder);
        Trade trade = new Trade();
        trade.setType(type);
        trade.setQuantity(tradeBuilder.quantity);
        trade.setPrice(tradeBuilder.price);
        trade.setStock(tradeBuilder.stock);
        order.addTrade(trade);
    }

    public static class TradeBuilder {
        private int quantity;
        private double price;

        Stock stock;
        public void stock(Consumer<StockBuilder> stockConsumer) {
            StockBuilder stockBuilder = new StockBuilder();
            stockConsumer.accept(stockBuilder);
            stock = new Stock();
            stock.setMarket(stockBuilder.market);
            stock.setSymbol(stockBuilder.symbol);


        }

        public void quantity(int quantity) {
            this.quantity = quantity;
        }

        public void price(double price) {
            this.price = price;
        }
    }

    public static class StockBuilder {
        private String symbol;
        private String market;

        public void symbol(String symbol) {
            this.symbol = symbol;
        }

        public void market(String market) {
            this.market = market;
        }
    }




}
