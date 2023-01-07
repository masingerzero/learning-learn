package org.masingerzero.modernjava.chapter10;

import org.masingerzero.modernjava.model.Order;

import java.util.Arrays;
import java.util.function.DoubleFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.stream.Collectors;

public class TaxCalculatorV2 {

    public static double calculateTaxes(Order order, Tax... taxes) {

//        double totalTax = Arrays.stream(taxes)
//                .mapToDouble(tax -> {
//                    System.out.println(tax);
//                    double v = tax.getTaxFunction().applyAsDouble(order.getValue());
//                    System.out.println(order.getValue());
//                    System.out.println(v);
//                    return v;
//                })
//                .sum();
//        return totalTax;

        DoubleUnaryOperator reduce = Arrays.stream(taxes)
                .map(Tax::getTaxFunction)
                .reduce(DoubleUnaryOperator.identity(), DoubleUnaryOperator::andThen);
        double v = reduce.applyAsDouble(order.getValue());
        System.out.println(v);

        return v;


    }

    enum Tax {

        REGIONAL(value -> value * 1.1),
        GENERAL(value -> value * 1.3),
        SURCHARGE(value -> value * 1.05);

        private DoubleUnaryOperator taxFunction;

        Tax(DoubleUnaryOperator taxFunction) {
            this.taxFunction = taxFunction;
        }

        public DoubleUnaryOperator getTaxFunction() {
            return taxFunction;
        }
    }
}
