package com.john.leetcode;

public class Question135 {

	public static void main(String[] args) {
		int[] ratings = new int[] { 3, 4 };
		System.out.println(new Question135().candy(ratings));
	}

	public int candy(int[] ratings) {
		if (ratings.length < 2) {
			return ratings.length;
		}

		// candy on left
		int[] candyLeft = new int[ratings.length];
		candyLeft[0] = 1;
		for (int i = 1; i < ratings.length; i++) {
			if (ratings[i] > ratings[i - 1]) {
				candyLeft[i] = candyLeft[i - 1] + 1;
			} else {
				candyLeft[i] = 1;
			}
		}

		// candy on right
		int[] candyRight = new int[ratings.length];
		candyRight[candyRight.length - 1] = 1;
		for (int i = ratings.length - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				candyRight[i] = candyRight[i + 1] + 1;
			} else {
				candyRight[i] = 1;
			}
		}

		int sum = 0;
		for (int i = 0; i < ratings.length; i++) {
			sum += Math.max(candyRight[i], candyLeft[i]);
		}

		return sum;
	}

}
