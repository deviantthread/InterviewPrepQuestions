package com.john.leetcode.template.q1_99;

public class Question80 {
    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }

        int dst = 0;
        int src = 1;
        int dupsInRow = 0;

        while (src < nums.length) {
            if (nums[src - 1] == nums[src]) {
                dupsInRow++;
            } else {
                dupsInRow = 0;
            }

            // its in, keep it
            if (dupsInRow < 2) {
                nums[++dst] = nums[src];
            }

            src++;
        }

        return dst + 1;
    }
}
