package com.john.leetcode.Nov2022.q1_99;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question46 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> ret = new ArrayList<>();
        Set<Integer> chosenIndexes = new HashSet<>();

        permuteRecurse(nums, ret, chosenIndexes, new ArrayList<>());

        return ret;
    }

    private void permuteRecurse(int[] nums, List<List<Integer>> ret, Set<Integer> chosenIndexes, List<Integer> permutation) {
        if (chosenIndexes.size() == nums.length) {
            ret.add(cloneList(permutation));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!chosenIndexes.contains(i)) {
                chosenIndexes.add(i);
                permutation.add(nums[i]);
                permuteRecurse(nums, ret, chosenIndexes, permutation);
                chosenIndexes.remove(i);
                permutation.remove(permutation.size() - 1);
            }
        }
    }

    private List<Integer> cloneList(List<Integer> permutation) {
        return new ArrayList<>(permutation);
    }
}
