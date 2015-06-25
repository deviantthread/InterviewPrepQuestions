package com.john.leetcode;

public class Question55 {

    public static void main(String[] args) {
        int[] nums = { 2, 10, 0, 0, 0, 0, 0, 0, 4 };
        boolean canJump = new Question55().canJump(nums);
        System.out.println(canJump);
    }

    public boolean canJump(int[] nums) {
        return canJump(nums, 0);
    }

    private boolean canJump(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return true;
        }

        int jump = nums[i];
        while (jump > 0) {
            boolean success = canJump(nums, i + jump);
            if (success) {
                return success;
            }
            jump--;
        }

        return false;
    }
}
