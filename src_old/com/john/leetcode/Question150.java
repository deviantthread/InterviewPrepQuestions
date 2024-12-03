package com.john.leetcode;

import java.util.Stack;

public class Question150 {

	public static void main(String[] args) {
		String[] tokens = { "-4", "5", "+" }; // 1
		// String[] tokens = { "2", "1", "+", "3", "*" }; // 9

		System.out.println(new Question150().evalRPN(tokens));
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < tokens.length; i++) {
			String token = tokens[i];

			Integer num = null;
			try {
				num = Integer.parseInt(token);
			} catch (NumberFormatException e) {
			}

			if (num != null) {
				stack.push(num);
			} else {
				int rhs = stack.pop();
				int lhs = stack.pop();

				if (token.equals("+")) {
					stack.push(lhs + rhs);
				} else if (token.equals("*")) {
					stack.push(lhs * rhs);
				} else if (token.equals("/")) {
					stack.push(lhs / rhs);
				} else if (token.equals("-")) {
					stack.push(lhs - rhs);
				} else {
					throw new RuntimeException("error will robinson");
				}
			}
		}

		return stack.pop();
	}
}
