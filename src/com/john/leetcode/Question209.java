package com.john.leetcode;

public class Question209 {

	public static void main(String[] args) {
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int s = 7;
		System.out.println(new Question209().minSubArrayLen(s, nums));

	}

	public int minSubArrayLen(int s, int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int low = 0;
		int high = 0;
		int ret = Integer.MAX_VALUE;
		int currSum = 0;

		while (low < nums.length) {
			if (low == high) {
				if (nums[low] > s) {
					return 1;
				} else {
					currSum += nums[high++];
				}
			}

			if (currSum < s) {
				if (high < nums.length) {
					currSum += nums[high++];
				} else {
					break;
				}
			} else if (currSum >= s) {
				currSum -= nums[low++];
				ret = Math.min(ret, high - low + 1);
			}
		}
		System.out.println("low: " + low);
		System.out.println("high: " + high);
		return ret == Integer.MAX_VALUE ? 0 : ret;
	}

}
