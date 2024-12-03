package com.john.leetcode.template.q100_199;

import java.util.Arrays;

public class Question198 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] mem = new int[nums.length];
        Arrays.fill(mem, -1);
        return rob(nums, mem, 0);
    }

    private int rob(int[] nums, int[] mem, int idx) {
        if (idx >= nums.length) {
            return 0;
        } else if (mem[idx] >= 0) {
            return mem[idx];
        }

        //either we rob this house and skip the next house, or we skip this house and rob the next house.
        //and keep the one that maxes out
        int robThisHouse = nums[idx] + rob(nums, mem, idx + 2);
        int skipThisHouse = rob(nums, mem, idx + 1);

        int betterChoice = Math.max(robThisHouse, skipThisHouse);
        mem[idx] = betterChoice;

        return betterChoice;
    }
}