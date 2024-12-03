package com.john.leetcode.Nov2022.q1_99;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!valueToIndices.containsKey(nums[i])) {
                valueToIndices.put(nums[i], new ArrayList<>());
            }

            valueToIndices.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int ijSum = nums[i] + nums[j];
                int target = -1 * ijSum;
                Integer k = findTargetIndex(valueToIndices, target, i, j);
                if (k != null) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    result.add(list);
                }
            }
        }

        return result;
    }

    private Integer findTargetIndex(Map<Integer, List<Integer>> valueToIndices, int target, int i, int j) {
        if (!valueToIndices.containsKey(target)) {
            return null;
        }

        for (Integer index : valueToIndices.get(target)) {
            if (index > j) {
                return index;
            }
        }
        return null;
    }
}
