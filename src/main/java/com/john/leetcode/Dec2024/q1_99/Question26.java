package com.john.leetcode.Dec2024.q1_99;

public class Question26 {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int dst = 0;
        for (int src = 1; src < nums.length; src++) {
            // its unique, copy it to the head of the array
            if (nums[src] != nums[dst]) {
                nums[++dst] = nums[src];
            }
        }

        return dst + 1;
    }
}