package com.john.leetcode;

public class Question55 {

    public static void main(String[] args) {
        int[] nums = { 2, 10, 0, 0, 0, 0, 0, 0, 4 };
        boolean canJump = new Question55().canJump(nums);
        System.out.println(canJump);
    }

    public boolean canJump(int[] nums) {
        boolean hasZero = false;
        for (int num : nums) {
            if (num == 0) {
                hasZero = true;
                break;
            }
        }

        if (!hasZero) {
            return true;
        }

        return canJump(nums, 0);
    }

    private boolean canJump(int[] nums, int i) {
        if (i >= nums.length - 1) {
            return true;
        }

        int jump = nums[i];
        while (jump > 0) {
            if (canJump(nums, i + jump)) {
                return true;
            }
            jump--;
        }

        return false;
    }
}
