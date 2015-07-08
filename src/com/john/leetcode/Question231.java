package com.john.leetcode;

public class Question231 {

	public static void main(String[] args) {
		int n = 9;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(new Question231().isPowerOfTwo(n));
	}

	public boolean isPowerOfTwo(int n) {
		boolean hasOne = false;
		for (int i = 0; i < 31; i++) {
			if ((n & 1) == 1) {
				if (hasOne) {
					return false;
				}
				hasOne = true;
			}
			n = n >> 1;
		}

		// neg
		if ((n & 1) == 1) {
			return false;
		}

		return hasOne;
	}
}
