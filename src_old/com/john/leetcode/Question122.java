package com.john.leetcode;

import com.google.common.base.Stopwatch;

public class Question122 {
	static int[] prices = { 2, 1, 4, 5, 2, 9, 7 };

	public static void main(String[] args) {
		Stopwatch sw = new Stopwatch();
		sw.start();
		System.out.println("ret: " + new Question122().maxProfit(prices));
		sw.stop();
		System.out.println("ms:  " + sw.elapsedMillis());

	}

	private int[] buyMem;
	private int[] sellMem;

	public int maxProfit(int[] prices) {
		int profit = 0;
		if (prices == null || prices.length < 2) {
			return profit;
		}

		int start = findStart(prices, 1);
		if (start >= prices.length) {
			return profit;
		}
		buyMem = new int[prices.length];
		sellMem = new int[prices.length];
		for (int i = 0; i < prices.length; i++) {
			buyMem[i] = sellMem[i] = -1;
		}

		return maxProfitBuy(prices, start);
	}

	private int findStart(int[] prices, int i) {
		for (; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				return i - 1;
			}
		}
		return prices.length;
	}

	private int maxProfitBuy(int[] prices, int i) {
		if (i >= prices.length) {
			return 0;
		}

		if (buyMem[i] != -1) {
			return buyMem[i];
		}

		// either buy now and try to sell it tomorrow, or buy tomorrow
		int buyNowProfit = maxProfitSell(prices, prices[i], i + 1);

		int nextPossibleBuyDay = findStart(prices, i + 2);
		int buyTomorrow = maxProfitBuy(prices, nextPossibleBuyDay);

		buyMem[i] = Math.max(buyNowProfit, buyTomorrow);
		return buyMem[i];
	}

	private int maxProfitSell(int[] prices, int buyPrice, int i) {
		if (i >= prices.length) {
			return 0;
		}

		if (sellMem[i] != -1) {
			return sellMem[i];
		}
		// either sell today and buy tomorrow, or sell tomorrow
		int sellNowProfit = prices[i] - buyPrice;
		if (sellNowProfit > 0) {
			sellNowProfit += maxProfitBuy(prices, i + 1);
		}

		int sellDay = findNextAvailableSellDay(prices, buyPrice, i + 1);
		if (sellDay >= prices.length) {
			sellMem[i] = Math.max(sellNowProfit, 0);
			return sellMem[i];
		}

		int sellTomorrow = maxProfitSell(prices, buyPrice, sellDay);

		sellMem[i] = Math.max(sellNowProfit, sellTomorrow);
		return sellMem[i];
	}

	private int findNextAvailableSellDay(int[] prices, int buyPrice, int i) {
		for (; i < prices.length; i++) {
			if (prices[i] - buyPrice > 0) {
				break;
			}
		}
		return i;
	}
}
