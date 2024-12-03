package com.john.leetcode;

public class Question201 {

	public static void main(String[] args) {
		int m = 2147483647;
		int n = 2147483647;
		System.out.println(new Question201().rangeBitwiseAnd(m, n));
	}

	public int rangeBitwiseAnd(int m, int n) {
		if (rangeIncludesZero(m, n)) {
			return 0;
		} else if (m == n) {
			return m;
		}

		int ret = m;
		for (int i = m + 1; i < n; i++) {
			System.out.println(ret);
			if (ret == 0) {
				break;
			}
			ret = ret & i;
		}

		return ret;
	}

	private boolean rangeIncludesZero(int m, int n) {
		return m <= 0 && n >= 0;
	}

}
