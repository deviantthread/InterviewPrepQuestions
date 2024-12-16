package com.john.leetcode.Dec2024.q1900_1999;

public class Question1929 {
    public int[] getConcatenation(int[] nums) {
        int[] ret = new int[nums.length * 2];

        for (int i = 0; i < nums.length; i++) {
            ret[i] = nums[i];
            ret[i + nums.length] = nums[i];
        }

        return ret;
    }
}
