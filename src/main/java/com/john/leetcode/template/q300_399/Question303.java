package com.john.leetcode.template.q300_399;

public class Question303 {
    public static class NumArray {

        private final int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int left, int right) {
            int sum = 0;

            while (left <= right) {
                sum += nums[left++];
            }

            return sum;
        }
    }
}
