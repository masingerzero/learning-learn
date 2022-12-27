package org.masingerzero.modernjava.chapter09;

import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        String stringTest = "hello world";
        UnaryOperator<String> upperCaseOperation = String::toUpperCase;
        UnaryOperator<String> quitSpacesOperation = s -> s.replace(" ", "");
        Function<String, String> composedFunction = upperCaseOperation.andThen(quitSpacesOperation);

        String result = composedFunction.apply(stringTest);


    }
}

abstract class ProcessingObject<T> {
    protected ProcessingObject<T> successor;

    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T input);
}

class ProcessToUpperCase extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.toUpperCase();
    }
}

class ProcessToQuitSpaces extends ProcessingObject<String> {
    @Override
    protected String handleWork(String input) {
        return input.replace(" ", "");
    }
}


class ProcessingObjectFunctional<T> {
    private ProcessingObjectFunctional<T> successor;
    private UnaryOperator<T> work;

    public ProcessingObjectFunctional(UnaryOperator<T> work) {
        this.work = work;
    }

    public void setSuccessor(ProcessingObjectFunctional<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T r = work.apply(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }


}