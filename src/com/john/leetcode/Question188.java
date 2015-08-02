package com.john.leetcode;

public class Question188 {

	public static void main(String[] args) {
		int k = 2;
		int[] prices = { 1, 4, 6, 8, 2, 4, 7, 9 };// 12 bucks
		System.out.println(new Question188().maxProfit(k, prices));
	}

	public int maxProfit(int k, int[] prices) {
		if (k <= 0) {
			return 0;
		}

		int[][] mem = new int[prices.length][prices.length];
		for (int row = 0; row < mem.length; row++) {
			mem[row] = new int[prices.length];
			for (int col = 0; col < mem[row].length; col++) {
				mem[row][col] = Integer.MIN_VALUE;
			}
		}
		return buyStock(prices, 0, k, mem);
	}

	private int buyStock(int[] prices, int idx, int transLeft, int[][] mem) {
		if (idx >= prices.length || transLeft == 0) {
			return 0;
		}
		if (mem[idx][0] != Integer.MIN_VALUE) {
			return max(mem[idx]);
		}

		int max = Math.max(
				// nah, i'll buy tomorrow
				buyStock(prices, idx + 1, transLeft, mem),
				// bought it today
				sellStock(prices, idx + 1, idx, transLeft - 1, mem));

		mem[idx][0] = max;
		return max;
	}

	private int max(int[] is) {
		int max = Integer.MIN_VALUE;
		for (int num : is) {
			max = Math.max(num, max);
		}
		return max;
	}

	private int sellStock(int[] prices, int idx, int buyIdx, int transLeft, int[][] mem) {
		if (idx >= prices.length) {
			return 0;
		}
		if (mem[buyIdx][idx] != Integer.MIN_VALUE) {
			return mem[buyIdx][idx];
		}

		int profitToday = prices[idx] - prices[buyIdx];

		int max = Math.max(
				// nah, i'll sell it tomorrow
				sellStock(prices, idx + 1, buyIdx, transLeft, mem),
				// sell it today
				profitToday + buyStock(prices, idx + 1, transLeft, mem));
		mem[buyIdx][idx] = max;
		return max;
	}

}
