package com.john.leetcode;

import java.util.HashSet;
import java.util.Set;

public class Question136 {

	public static void main(String[] args) {

		int[] nums = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 6, 7, 7, 8, 8, 9, 9, 10,
				10 };
		int singleNumber = new Question136().singleNumber(nums);
		int singleNumberXor = new Question136().singleNumberXOR(nums);
		System.out.println(singleNumber);
		System.out.println(singleNumberXor);
	}

	private int singleNumberXOR(int[] nums) {
		int ret = 0;
		for(int num : nums){
			ret = ret ^ num;
		}
		
		return ret;
	}

	public int singleNumber(int[] nums) {
		Set<Integer> set = new HashSet<Integer>();

		for (int num : nums) {
			if (set.contains(num)) {
				set.remove(num);
			} else {
				set.add(num);
			}
		}

		return set.iterator().next();
	}

}
