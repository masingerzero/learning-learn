package org.masingerzero.chapter5.legacyLibWithGenClient.minimalchanges;

public class Stacks {

    public static<E> Stack<E> reverse(Stack<E> stack) {
        Stack reverseStack = new ArrayStack();
        while (!stack.empty()) {
            Object o = stack.pop();
            reverseStack.push(o);
        }
        return reverseStack;
    }


}
