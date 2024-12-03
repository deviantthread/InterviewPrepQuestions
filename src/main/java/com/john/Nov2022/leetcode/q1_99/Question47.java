package com.john.Nov2022.leetcode.q1_99;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<>();

        boolean[] picked = new boolean[nums.length];
        List<Integer> curr = new ArrayList<>();

        permuteUniqueRecurse(nums, picked, ret, curr);

        return ret;
    }

    private void permuteUniqueRecurse(int[] nums, boolean[] picked, List<List<Integer>> ret, List<Integer> curr) {
        if (curr.size() == nums.length) {
            ret.add(new ArrayList<>(curr));
            return;
        }

        int preVal = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // don't let the same value be used for the same position
            if (picked[i] || preVal == nums[i]) {
                continue;
            }

            preVal = nums[i];
            picked[i] = true;
            curr.add(nums[i]);
            permuteUniqueRecurse(nums, picked, ret, curr);
            picked[i] = false;
            curr.remove(curr.size() - 1);
        }
    }
}
