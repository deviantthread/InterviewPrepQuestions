package com.john.Nov2022.leetcode.q700_799;

public class Question724 {
    public int pivotIndex(int[] nums) {
        int[] leftSums = new int[nums.length];

        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            leftSums[i] = currSum;
        }

        int[] rightSums = new int[nums.length];

        currSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            currSum += nums[i];
            rightSums[i] = currSum;
        }

        for (int i = 0; i < nums.length; i++) {
            if (leftSums[i] == rightSums[i]) {
                return i;
            }
        }

        return -1;
    }
}
