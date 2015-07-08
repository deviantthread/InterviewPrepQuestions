package com.john.leetcode;

import java.util.EmptyStackException;
import java.util.Stack;

public class Question232 {

    public static void main(String[] args) {
        Question232 queue = new Question232();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        queue.pop();
        System.out.println(queue.peek());
        queue.pop();
    }

    Stack<Integer> inStack = new Stack<Integer>();
    Stack<Integer> outStack = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        inStack.add(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if (outStack.isEmpty() && inStack.isEmpty()) {
            throw new EmptyStackException();
        }
        if (outStack.isEmpty()) {
            dumpQueues();

        }

        outStack.pop();
    }

    private void dumpQueues() {
        while (!inStack.isEmpty()) {
            outStack.add(inStack.pop());
        }
    }

    // Get the front element.
    public int peek() {
        if (outStack.isEmpty() && inStack.isEmpty()) {
            throw new EmptyStackException();
        }
        if (outStack.isEmpty()) {
            dumpQueues();
        }
        return outStack.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return outStack.isEmpty() && inStack.isEmpty();
    }
}
