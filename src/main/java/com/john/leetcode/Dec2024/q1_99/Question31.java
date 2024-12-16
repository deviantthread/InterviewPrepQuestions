package com.john.leetcode.Dec2024.q1_99;

import java.util.Arrays;

public class Question31 {
    public void nextPermutation(int[] nums) {
        /*
        find the right-most position that can be increased, sort everything to the right of that
         */
        if (nums == null || nums.length < 2) {
            return;
        }

        int changeIdx;
        for (changeIdx = nums.length - 2; changeIdx >= 0; changeIdx--) {
            if (canIncreaseIndex(nums, changeIdx)) {
                increaseIndex(nums, changeIdx);
                break;
            }
        }

        Arrays.sort(nums, changeIdx + 1, nums.length);
    }

    private void increaseIndex(int[] nums, int changeIdx) {
        int nextHighest = Integer.MAX_VALUE;
        int nextHighestIdx = changeIdx;

        for (int i = changeIdx + 1; i < nums.length; i++) {
            if (nums[i] > nums[changeIdx] && nums[i] < nextHighest) {
                nextHighestIdx = i;
            }
        }

        int temp = nums[changeIdx];
        nums[changeIdx] = nums[nextHighestIdx];
        nums[nextHighestIdx] = temp;
    }

    private boolean canIncreaseIndex(int[] nums, int changeIdx) {
        for (int i = changeIdx + 1; i < nums.length; i++) {
            if (nums[i] > nums[changeIdx]) {
                return true;
            }
        }
        return false;
    }
}