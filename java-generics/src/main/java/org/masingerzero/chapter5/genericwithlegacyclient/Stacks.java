package org.masingerzero.chapter5.genericwithlegacyclient;

public class Stacks {

    public static<E> Stack<E> reverse(Stack<E> stack) {
        Stack<E> reverseStack = new ArrayStack<>();
        while (!stack.empty()) {
            E e = stack.pop();
            reverseStack.push(e);
        }
        return reverseStack;
    }


}
