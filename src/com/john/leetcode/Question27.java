package com.john.leetcode;

public class Question27 {

    public static void main(String[] args) {
        int[] nums = { 1 };
        int val = 1;
        CollUtils.print(nums, "nums");
        int newLen = new Question27().removeElement(nums, val);
        CollUtils.print(nums, "removed");
        System.out.println("newLen: " + newLen);
    }

    public int removeElement(int[] nums, int val) {
        int count = 0;

        for (int num : nums) {
            if (num == val) {
                count++;
            }
        }

        int replaceIdx = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val && replaceIdx >= 0) {
                nums[i--] = nums[replaceIdx--];
            }
        }

        return nums.length - count;
    }

}
