package com.john.Nov2022.leetcode.q1_50;

public class Question45 {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int[] mem = new int[nums.length];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = -1;
        }

        jump(mem, 0, nums);

        return mem[0];
    }

    private int jump(int[] mem, int currStep, int[] nums) {
        if (currStep >= nums.length - 1) {
            return 0;
        } else if (mem[currStep] > 0) {
            return mem[currStep];
        }

        int bestJump = -1;
        for (int jump = nums[currStep]; jump > 0; jump--) {
            int possibleJump = jump(mem, currStep + jump, nums) + 1;
            if (bestJump > 0 && possibleJump > 0) {
                bestJump = Math.min(bestJump, possibleJump);
            } else if (bestJump < 0 && possibleJump > 0) {
                bestJump = possibleJump;
            }
        }

        if (bestJump > 0) {
            mem[currStep] = bestJump;
            return bestJump;
        }

        return -1;
    }
}
