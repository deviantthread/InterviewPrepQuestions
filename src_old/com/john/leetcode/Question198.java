package com.john.leetcode;

public class Question198 {

    public static void main(String[] args) {

    }

    public int rob(int[] nums) {
        int[] mem = new int[nums.length];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = -1;
        }
        return rob(nums, 0, mem);
    }

    private int rob(int[] nums, int i, int[] mem) {
        if (i >= nums.length) {
            return 0;
        } else if (mem[i] != -1) {
            return mem[i];
        }

        int robSum = nums[i] + rob(nums, i + 2, mem);
        int skipSum = rob(nums, i + 1, mem);

        mem[i] = Math.max(robSum, skipSum);
        return mem[i];
    }
}
