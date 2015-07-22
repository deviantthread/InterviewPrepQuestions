package com.john.leetcode;

public class Question121 {

	public static void main(String[] args) {
		int[] prices = { 1, 5, 10, 3, 6 };
		System.out.println(new Question121().maxProfit(prices));

	}

	public int maxProfit(int[] prices) {
		int profit = 0;
		if (prices == null || prices.length < 2) {
			return profit;
		}

		int min = prices[0];
		for (int price : prices) {
			min = Math.min(price, min);
			profit = Math.max(profit, price - min);
		}

		return profit;
	}
}
