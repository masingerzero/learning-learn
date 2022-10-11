package org.masingerzero.chapter5.legacy;

public class Stacks {

    public static Stack reverse(Stack stack) {
        Stack reverseStack = new ArrayStack();
        while (!stack.empty()) {
            Object o = stack.pop();
            reverseStack.push(o);
        }
        return reverseStack;
    }


}
