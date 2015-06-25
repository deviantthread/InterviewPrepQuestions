package com.john.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question1 {
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> num2index = new HashMap<Integer, Integer>();

		for (int i = 0; i < nums.length; i++) {
			num2index.put(nums[i], i);
		}

		for (int i = 0; i < nums.length; i++) {
			int deltaTarget = target - nums[i];
			if (!num2index.containsKey(deltaTarget)) {
				continue;
			}

			Integer index = num2index.get(deltaTarget);
			if (index > i) {
				return new int[] { i + 1, index + 1 };
			}
		}
		return new int[] { -1, -1 };
	}
}
