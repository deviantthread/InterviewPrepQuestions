package com.john.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Question202 {

	public static void main(String[] args) {
		int n = 19;
		System.out.println(new Question202().isHappy(n));
	}

	public boolean isHappy(int n) {
		Set<Integer> numsSeenSoFar = new HashSet<Integer>();
		int currSum = n;
		while (true) {
			if (currSum == 1) {
				return true;
			} else {
				currSum = calcNum(currSum);
				if (numsSeenSoFar.contains(currSum)) {
					return false;
				}
			}

			numsSeenSoFar.add(currSum);
		}

	}

	private int calcNum(int currSum) {
		int newSum = 0;

		for (char c : String.valueOf(currSum).toCharArray()) {
			newSum += Math.pow(Integer.parseInt(String.valueOf(c)), 2);
		}

		return newSum;
	}

}
