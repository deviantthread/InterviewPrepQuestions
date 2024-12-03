package com.john.leetcode;

import java.util.Stack;

public class Question155 {

    public static void main(String[] args) {
        Question155 myStack = new Question155();

        myStack.push(10);
        System.out.println("min - " + myStack.getMin());
        System.out.println("top - " + myStack.top());
        myStack.push(20);
        System.out.println("min - " + myStack.getMin());
        System.out.println("top - " + myStack.top());
        myStack.push(3);
        myStack.push(40);
        System.out.println("min - " + myStack.getMin());
        System.out.println("top - " + myStack.top());
        myStack.push(50);
        myStack.push(60);
        System.out.println("min - " + myStack.getMin());
        System.out.println("top - " + myStack.top());
    }

    private final Stack<StackElement> stack = new Stack<StackElement>();

    public void push(int x) {
        int currMin = stack.isEmpty() ? Integer.MAX_VALUE : stack.peek().min;
        int min = Math.min(x, currMin);
        stack.push(new StackElement(x, min));
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }

    private static class StackElement {
        int val;
        int min;

        public StackElement(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }
}
