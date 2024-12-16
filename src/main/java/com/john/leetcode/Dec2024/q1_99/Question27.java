package com.john.leetcode.Dec2024.q1_99;

public class Question27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int dst = 0;
        for (int src = 0; src < nums.length; src++) {
            if (nums[src] != val) {
                nums[dst++] = nums[src];
            }
        }

        return dst;
    }
}