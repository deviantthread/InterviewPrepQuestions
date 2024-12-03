package com.john.leetcode;

import java.util.List;

public class Question241 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> diffWaysToCompute(String input) {
		MathNode exp = buildMathExpr(input);
		int opCount = countOperators(exp);
		return null;
	}

	private int countOperators(MathNode exp) {
		// TODO Auto-generated method stub
		return 0;
	}

	private MathNode buildMathExpr(String input) {
		// TODO Auto-generated method stub
		return null;
	}

	private static class MathNode {
		Character op = null;
		int num = 0;
		MathNode prev = null;
		MathNode next = null;

		public boolean isOp() {
			return op != null;
		}

	}
}
