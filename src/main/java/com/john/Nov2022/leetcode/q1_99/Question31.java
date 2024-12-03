package com.john.Nov2022.leetcode.q1_99;

import java.util.Arrays;

public class Question31 {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        // if its max number, sort entire array
        if (isMaxNumber(nums)) {
            Arrays.sort(nums);
            return;
        }

        // find index of right-most number that is lower than its right neighbor
        int leftSwapIndex = findLeftSwapIndex(nums);

        // swap that number with lowest, next-highest number on right side
        int rightSwapIndex = findRightSwapIndex(nums, leftSwapIndex);

        int temp = nums[leftSwapIndex];
        nums[leftSwapIndex] = nums[rightSwapIndex];
        nums[rightSwapIndex] = temp;

        // sort remaining right numbers
        Arrays.sort(nums, leftSwapIndex + 1, nums.length);
    }

    private boolean isMaxNumber(int[] nums) {
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev < nums[i]) {
                return false;
            }
            prev = nums[i];
        }

        return true;
    }

    private int findLeftSwapIndex(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                return i;
            }
        }

        return -1;
    }

    private int findRightSwapIndex(int[] nums, int leftSwapIndex) {
        int leftNum = nums[leftSwapIndex];
        Integer rightSwapIdx = null;

        for (int i = nums.length - 1; i > leftSwapIndex; i--) {
            if (nums[i] > leftNum) {
                //if we haven't found a right index yet, or its better than the one we did find, save it
                if (rightSwapIdx == null || nums[i] < nums[rightSwapIdx]) {
                    rightSwapIdx = i;
                }
            }
        }
        return rightSwapIdx;
    }
}
