package com.john.Nov2022.leetcode.q51_100;

public class Question55 {
    public boolean canJump(int[] nums) {
        Boolean[] jumpable = new Boolean[nums.length];
        return canJump(nums, 0, jumpable);
    }

    private boolean canJump(int[] nums, int step, Boolean[] jumpable) {
        if (step == nums.length - 1) {
            return true;
        } else if (step >= nums.length) {
            return false;
        } else if (jumpable[step] != null) {
            return jumpable[step];
        }

        for (int jump = nums[step]; jump > 0; jump--) {
            boolean finish = canJump(nums, step + jump, jumpable);
            // made it
            if (finish) {
                jumpable[step] = true;
                return true;
            }
        }

        // no size jump worked from this step
        jumpable[step] = false;
        return false;
    }
}
