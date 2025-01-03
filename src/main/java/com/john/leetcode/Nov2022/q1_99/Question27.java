package com.john.leetcode.Nov2022.q1_99;

public class Question27 {
    public int removeElement(int[] nums, int val) {
        int dst = 0;

        for (int src = 0; src < nums.length; src++) {
            if (nums[src] != val) {
                nums[dst++] = nums[src];
            }
        }

        return dst;
    }
}
