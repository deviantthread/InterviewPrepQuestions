package com.john.Nov2022.leetcode.q900_999;

public class Question912 {

    // insertion sort
    public int[] sortArray(int[] nums) {
        for (int idx = 1; idx < nums.length; idx++) {
            for (int swapIdx = idx - 1; swapIdx >= 0 && nums[swapIdx] > nums[swapIdx + 1]; swapIdx--) {
                int tmp = nums[swapIdx];
                nums[swapIdx] = nums[swapIdx + 1];
                nums[swapIdx + 1] = tmp;
            }
        }
        return nums;
    }
}
