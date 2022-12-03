package com.john.Nov2022.leetcode.q1_50;

public class Question26 {
    public int removeDuplicates(int[] nums) {
        int dst = 0;
        for (int src = 1; src < nums.length; src++) {
            if (nums[src] != nums[dst]) {
                nums[++dst] = nums[src];
            }
        }

        return dst + 1;
    }
}
