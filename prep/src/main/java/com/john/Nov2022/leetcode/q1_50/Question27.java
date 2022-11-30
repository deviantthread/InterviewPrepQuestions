package com.john.Nov2022.leetcode.q1_50;

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
