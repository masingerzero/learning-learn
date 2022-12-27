package org.masingerzero.modernjava.chapter10;

import org.masingerzero.modernjava.model.*;
import org.masingerzero.modernjava.model.Car.Color;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static org.masingerzero.modernjava.chapter10.FunctionSequencingOrderBuilder.order;

public class Chapter10SandBox {

//    Order order = order( o -> {
//        o.forCustomer( "BigBank" );
//        o.buy( t -> {
//            t.quantity( 80 );
//            t.price( 125.00 );
//            t.stock( s -> {
//                s.symbol( "IBM" );
//                s.market( "NYSE" );
//            } );
//        });

//        o.sell( t -> {
//            t.quantity( 50 );
//            t.price( 375.00 );
//            t.stock( s -> {
//                s.symbol( "GOOGLE" );
//                s.market( "NASDAQ" );
//            } );
//        });
//    } );

    public static void main(String[] args) {

        Order order = order(o -> {
            o.forCustomer("BigBank");
            o.buy(t -> {
                t.quantity(80);
                t.price(125.00);
                t.stock(s -> {
                    s.symbol("IBM");
                    s.market("NYSE");
                });
            });
            o.sell(t -> {
                t.quantity(50);
                t.price(375.00);
                t.stock(s -> {
                    s.symbol("GOOGLE");
                    s.market("NASDAQ");
                });
            });
        });

        System.out.println(order);
        System.out.println(order.getTrades());

        Order expectedOrder = new Order("John");
        Stock stock1 = new Stock("AMZN", "NASDAQ");
        Stock stock2 = new Stock("TSLA", "NASDAQ");
        Trade trade1 = new Trade(Trade.Type.BUY, stock1, 1000, 12.2);
        Trade trade2 = new Trade(Trade.Type.SELL, stock2, 100, 23.3);
        expectedOrder.addTrade(trade1);
        expectedOrder.addTrade(trade2);


    }


}




