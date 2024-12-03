package com.john.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question128 {

	public static void main(String[] args) {

		int[] nums = { 100, 4, 300, 1, 3, 2 };
		System.out.println(new Question128().longestConsecutive(nums));
	}

	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int num : nums) {
			map.put(num, -1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			entry.setValue(findConsecutive(map, entry.getKey()));
		}

		int max = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			max = Math.max(max, entry.getValue());
		}

		return max;
	}

	private Integer findConsecutive(Map<Integer, Integer> map, Integer key) {
		if (map.get(key) != -1) {
			return map.get(key);
		}

		// if my next lower value doesn't exist, i'm it
		if (!map.containsKey(key - 1)) {
			map.put(key, 1);
			// find out how many are directly less than me
		} else {
			int val = findConsecutive(map, key - 1);
			map.put(key, val + 1);
		}

		return map.get(key);
	}
}
