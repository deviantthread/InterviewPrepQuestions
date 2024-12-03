package com.john.leetcode;

public class Question189 {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		new Question189().rotate(nums, k);
		CollUtils.print(nums);
	}

	public void rotate(int[] nums, int k) {
		while (k > nums.length) {
			k -= nums.length;
		}
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	private void reverse(int[] nums, int i, int j) {
		while (i < j) {
			int tmp = nums[i];
			nums[i++] = nums[j];
			nums[j--] = tmp;
		}
	}

}
