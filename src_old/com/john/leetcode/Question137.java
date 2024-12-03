package com.john.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question137 {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 9, 9, 9, 10, 10, 10 };
		int singleNumber = new Question137().singleNumber(nums);
		System.out.println(singleNumber);
	}

	public int singleNumber(int[] nums) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int num : nums) {
			if (map.containsKey(num)) {
				Integer val = map.get(num);
				val++;
				map.put(num, val);
			} else {
				map.put(num, 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() != 3) {
				return entry.getKey();
			}
		}
		throw new RuntimeException("you lied to me");
	}

}
