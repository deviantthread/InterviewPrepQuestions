package com.john.leetcode;

public class Question41 {

	public static void main(String[] args) {
		int[] nums = { 3, 4, -1, 1 };
		System.out.println(new Question41().firstMissingPositive(nums));
	}

	public int firstMissingPositive(int[] nums) {
		// pre process
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				nums[i] = Integer.MIN_VALUE;
			}
		}
		// set elems to -1
		for (int i = 0; i < nums.length; i++) {
			int idx = nums[i];
			setElem(nums, idx);
		}
		nums[0] = -1;

		// first -1 will be the answer
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != -1) {
				return i + 1;
			}
		}
		return -1;
	}

	private void setElem(int[] nums, int idx) {
		if (idx >= 0 && idx < nums.length) {
			int nextIdx = nums[idx];
			nums[idx] = -1;
			setElem(nums, nextIdx);
		}

	}

}
