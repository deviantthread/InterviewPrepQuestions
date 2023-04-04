package com.john.Nov2022.leetcode.q900_999;

public class Question918 {
    public int maxSubarraySumCircular(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }

        int maxSum = nums[0];

        for (int start = 0; start < nums.length; start++) {
            int currSum = 0;
            boolean first = true;

            for (int idx = start; idx != start || first; idx = (idx + 1) % nums.length) {
                first = false;
                currSum += nums[idx];
                maxSum = Math.max(maxSum, currSum);

                if (currSum < 0) {
                    currSum = 0;
                }
            }
        }

        return maxSum;
    }
}
