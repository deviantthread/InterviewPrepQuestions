package com.john.leetcode;

public class Question152 {

	public static void main(String[] args) {
		int[] nums = { -4, 5, -1 };
		int maxProduct = new Question152().maxProduct(nums);
		System.out.println(maxProduct);
	}

	public int maxProduct(int[] nums) {
		products = new int[nums.length + 1];
		for (int i = 0; i < products.length; i++) {
			products[i] = Integer.MIN_VALUE;
		}

		return findMax(nums, 0, 1);
	}

	int[] products;

	private int findMax(int[] nums, int idx, int currProduct) {
		if (idx >= nums.length) {
			return currProduct;
		} else if (currProduct == 0) {
			return 0;
		}

		if (products[idx + 1] == Integer.MIN_VALUE) {
			products[idx + 1] = findMax(nums, idx + 1, 1);
		}

		int newProduct = nums[idx] * currProduct;
		return Math
				.max(Math.max(findMax(nums, idx + 1, newProduct),
						products[idx + 1]), currProduct);
	}
}
