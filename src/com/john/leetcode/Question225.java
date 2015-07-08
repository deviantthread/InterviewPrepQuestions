package com.john.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Question225 {

	public static void main(String[] args) {
		Question225 myStack = new Question225();

		// fails for this scenario. inQ has one element that is the top element
		myStack.push(1);
		myStack.push(2);
		System.out.println(myStack.top());
		myStack.push(3);
		myStack.push(4);
		System.out.println(myStack.top());

		// myStack.push(4);
		// System.out.println(myStack.top());
		// myStack.pop();
		// System.out.println(myStack.top());
		// myStack.pop();
		// System.out.println(myStack.top());
		// myStack.pop();
		// System.out.println(myStack.top());
		// myStack.pop();
	}

	Queue<Integer> inQ = new LinkedList<Integer>();
	Queue<Integer> outQ = new LinkedList<Integer>();

	// Push element x onto stack.
	public void push(int x) {
		inQ.add(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		if (outQ.isEmpty()) {
			dumpQueues();
		} else if (!inQ.isEmpty()) {
			moveInToOut();
		}

		outQ.remove();
	}

	private void moveInToOut() {
		while (!outQ.isEmpty()) {
			inQ.add(outQ.remove());
		}
		dumpQueues();
	}

	// Get the top element.
	public int top() {
		if (outQ.isEmpty()) {
			dumpQueues();
		} else if (!inQ.isEmpty()) {
			moveInToOut();
		}

		return outQ.peek();
	}

	private void dumpQueues() {
		if (inQ.isEmpty()) {
			return;
		}
		int x = inQ.remove();
		dumpQueues();
		outQ.add(x);
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return inQ.isEmpty() && outQ.isEmpty();
	}
}
