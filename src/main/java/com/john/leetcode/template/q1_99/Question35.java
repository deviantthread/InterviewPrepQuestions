package com.john.leetcode.template.q1_99;

public class Question35 {
    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        } else if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        return binarySearch(nums, target, 0, nums.length - 1);
    }

    private int binarySearch(int[] nums, int target, int left, int right) {
        int mid = left + (right - left) / 2;

        if (nums[mid] == target) { // found it
            return mid;
        } else if (nums[mid] > target) {
            if (mid > 0 && nums[mid - 1] < target) { // bigger, but barely
                return mid;
            } else {
                return binarySearch(nums, target, left, mid - 1);
            }
        } else {
            if (mid + 1 < nums.length - 1 && nums[mid + 1] > target) { // smaller but barely
                return mid + 1;
            } else {
                return binarySearch(nums, target, mid + 1, right);
            }
        }
    }
}
