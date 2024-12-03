package com.john.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Question225 {

	public static void main(String[] args) {
		Question225 myStack = new Question225();

		myStack.push(1);
		myStack.push(2);
		System.out.println(myStack);
		System.out.println("top: " + myStack.top());
		System.out.println(myStack);
		myStack.push(3);
		myStack.push(4);
		System.out.println(myStack);
		System.out.println("top: " + myStack.top());
		System.out.println(myStack);
	}

	Queue<Integer> inQ = new LinkedList<Integer>();
	Queue<Integer> outQ = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		if (!outQ.isEmpty()) {
			dumpOutToIn();
		}

		inQ.add(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (outQ.isEmpty()) {
			dumpInToOut();
		}

		outQ.remove();
	}

	// Get the top element.
	public int top() {
		if (outQ.isEmpty()) {
			dumpInToOut();
		}

		return outQ.peek();
	}

	private void dumpInToOut() {
		if (inQ.isEmpty()) {
			return;
		}
		int x = inQ.remove();
		dumpInToOut();
		outQ.add(x);
	}

	private void dumpOutToIn() {
		if (outQ.isEmpty()) {
			return;
		}
		int x = outQ.remove();
		dumpOutToIn();
		inQ.add(x);
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return inQ.isEmpty() && outQ.isEmpty();
	}

	@Override
	public String toString() {
		return "\noutQ: " + outQ.toString() + "\ninQ: " + inQ.toString();
	}
}
