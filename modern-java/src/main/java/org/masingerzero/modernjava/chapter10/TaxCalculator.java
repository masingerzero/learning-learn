package org.masingerzero.modernjava.chapter10;

import org.masingerzero.modernjava.model.Order;

import java.util.function.DoubleUnaryOperator;

public class TaxCalculator {
    DoubleUnaryOperator taxFunction = DoubleUnaryOperator.identity();


    public TaxCalculator with(DoubleUnaryOperator afterTaxFunction) {
        this.taxFunction = this.taxFunction.andThen(afterTaxFunction);
        return this;
    }

    public double calculate(Order order) {
        return this.taxFunction.applyAsDouble(order.getValue());
    }

    public static class Tax {
        public static double regional(double value) {
            System.out.println("Tax.regional");
            return value * 1.1;
        }

        public static double general(double value) {
            System.out.println("Tax.general");
            return value * 1.3;
        }


        public static double surcharge(double value) {
            System.out.println("Tax.surcharge");
            return value * 1.05;
        }
    }

}
