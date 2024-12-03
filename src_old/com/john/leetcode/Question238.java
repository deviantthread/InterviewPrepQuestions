package com.john.leetcode;

public class Question238 {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4 };
		CollUtils.print(nums, "input");
		int[] productExceptSelf = new Question238().productExceptSelf(nums);
		CollUtils.print(productExceptSelf, "result");
	}

	public int[] productExceptSelf(int[] nums) {
		int[] leftMult = new int[nums.length];
		leftMult[0] = 1;
		for (int i = 1; i < nums.length; i++) {
			leftMult[i] = leftMult[i - 1] * nums[i - 1];
		}

		int[] rightMult = new int[nums.length];
		rightMult[nums.length - 1] = 1;
		for (int i = nums.length - 2; i >= 0; i--) {
			rightMult[i] = rightMult[i + 1] * nums[i + 1];
		}

		int[] ret = new int[nums.length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = leftMult[i] * rightMult[i];
		}

		return ret;
	}

}
