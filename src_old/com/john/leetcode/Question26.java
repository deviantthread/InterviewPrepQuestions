package com.john.leetcode;

public class Question26 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4 };
        CollUtils.print(nums, "nums");
        int newLen = new Question26().removeDuplicates(nums);
        CollUtils.print(nums, "removed");
        System.out.println("newLen: " + newLen);
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int to = 0;
        int from = 0;
        Integer prev = null;
        while (from < nums.length) {
            if (prev == null || nums[from] != prev) {
                nums[to++] = nums[from];
                prev = nums[from];
            }

            from++;
        }

        return to;
    }

}
