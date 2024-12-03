package com.john.randominterviews;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class msquestions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printVertically(0);
	}

	public static void printVertically(int i) {
		if (i == 0) {
			System.out.println(0);
			return;
		}
		boolean isNeg = i < 0;
		if (isNeg) {
			i *= -1;
		}

		List<Integer> digits = new ArrayList<Integer>();
		while (i != 0) {
			digits.add(i % 10);
			i /= 10;
		}
		if (isNeg) {
			System.out.println("-");
		}
		for (int idx = digits.size() - 1; idx >= 0; idx--) {
			System.out.println(digits.get(idx));
		}
	}

	// in order traversal, verifying the node values are consistently increasing
	public static boolean isBSTValid(Node root) {
		if (root == null) {
			return true;
		}

		boolean isValid = true;
		Node last = null;

		Stack<Node> stack = new Stack<Node>();
		pushLeft(stack, root);

		while (!stack.isEmpty() && isValid) {
			Node node = stack.pop();
			if (last != null) {
				isValid = last.val <= node.val;
			}
			if (node.right != null) {
				pushLeft(stack, node.right);
			}

			last = node;
		}

		return isValid;
	}

	private static void pushLeft(Stack<Node> stack, Node node) {
		while (node != null) {
			stack.push(node);
			node = node.left;
		}
	}

	public class Node {
		Node left;
		Node right;
		int val;
	}
}
