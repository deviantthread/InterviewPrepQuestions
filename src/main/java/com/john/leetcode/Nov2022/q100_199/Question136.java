package com.john.leetcode.Nov2022.q100_199;

public class Question136 {
    public int singleNumber(int[] nums) {
        int val = nums[0];

        for (int i = 1; i < nums.length; i++) {
            val = val ^ nums[i];
        }
        return val;
    }
}
