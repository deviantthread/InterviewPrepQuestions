package com.john.leetcode.template.q1_99;

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
