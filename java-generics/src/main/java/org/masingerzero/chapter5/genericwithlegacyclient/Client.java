package org.masingerzero.chapter5.genericwithlegacyclient;



public class Client {
    public static void main(String[] args) {
        Stack stack = new ArrayStack();
        for (int i = 0; i<4; i++) stack.push(i);
        assert stack.toString().equals("stack[0, 1, 2, 3]");
        int top = (Integer)stack.pop();
        assert top == 3 && stack.toString().equals("stack[0, 1, 2]");
        Stack reverse = Stacks.reverse(stack);
        assert stack.empty();
        assert reverse.toString().equals("stack[2, 1, 0]");


        /////





    }
}


