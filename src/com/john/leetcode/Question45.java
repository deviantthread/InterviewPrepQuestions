package com.john.leetcode;

import com.google.common.base.Stopwatch;

public class Question45 {

	public static void main(String[] args) {
		Stopwatch sw = new Stopwatch();
		int[] nums = { 5, 6, 4, 4, 6, 9, 4, 4, 7, 4, 4, 8, 2, 6, 8, 1, 5, 9, 6, 5, 2, 7, 9, 7, 9, 6, 9, 4, 1, 6, 8, 8,
				4, 4, 2, 0, 3, 8, 5 };
		sw.start();
		System.out.println(new Question45().jump(nums));
		sw.stop();
		System.out.println("ms: " + sw.elapsedMillis());
	}

	public int jump(int[] nums) {
		if (isAllOnes(nums)) {
			return nums.length - 1;
		}

		int[] mem = new int[nums.length];
		for (int i = 0; i < mem.length; i++) {
			mem[i] = Integer.MAX_VALUE;
		}
		return jump(nums, 0, mem);
	}

	private boolean isAllOnes(int[] nums) {
		for (int num : nums) {
			if (num != 1) {
				return false;
			}
		}
		return true;
	}

	private int jump(int[] nums, int idx, int[] mem) {
		// made it, hooray!
		if (idx >= nums.length - 1) {
			return 0;
		}
		// failed :(
		if (nums[idx] <= 0) {
			return -1;
		}
		if (mem[idx] != Integer.MAX_VALUE) {
			return mem[idx];
		}

		int leastNumOfJumps = Integer.MAX_VALUE;
		for (int jump = nums[idx]; jump >= 1; jump--) {
			int result = jump(nums, idx + jump, mem);
			if (result >= 0) {
				leastNumOfJumps = Math.min(leastNumOfJumps, result + 1);
			}
		}

		mem[idx] = leastNumOfJumps;
		return mem[idx];
	}

}
