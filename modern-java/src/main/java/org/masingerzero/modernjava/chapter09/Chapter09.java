package org.masingerzero.modernjava.chapter09;


import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.masingerzero.modernjava.chapter09.ValidatorStrategies.LOWERCASE_VALIDATOR;
import static org.masingerzero.modernjava.chapter09.ValidatorStrategies.NUMERIC_VALIDATOR;

public class Chapter09 {
    public static void main(String[] args) {

        System.out.println("1111".matches("\\d+"));

        Validator numericValidator = new Validator(NUMERIC_VALIDATOR.getStrategy());
        boolean isNumeric = numericValidator.validate("1111c"); // return true

        Validator lowerCaseValidator = new Validator(LOWERCASE_VALIDATOR.getStrategy());
        boolean isLowercase = lowerCaseValidator.validate("abcdef"); //return true

    }


}

enum ValidatorStrategies {
    NUMERIC_VALIDATOR(s -> s.matches("\\d+")),
    LOWERCASE_VALIDATOR(s -> s.matches("[a-z]+"))
    ;

    private ValidatorStrategy strategy;

    ValidatorStrategies(ValidatorStrategy strategy) {
        this.strategy = strategy;
    }

    public ValidatorStrategy getStrategy() {
        return strategy;
    }
}

class Validator {
    private ValidatorStrategy validatorStrategy;

    public Validator(ValidatorStrategy validatorStrategy) {
        this.validatorStrategy = validatorStrategy;
    }

    public boolean validate(String s) {
        return validatorStrategy.validate(s);
    }
}


interface ValidatorStrategy {
    boolean validate(String s);
}
