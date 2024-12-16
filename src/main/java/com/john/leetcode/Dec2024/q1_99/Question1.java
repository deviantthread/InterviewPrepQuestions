package com.john.leetcode.Dec2024.q1_99;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List<Integer>> valToIdx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!valToIdx.containsKey(nums[i])) {
                valToIdx.put(nums[i], new ArrayList<>());
            }

            valToIdx.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (valToIdx.containsKey(complement)) {
                List<Integer> indices = valToIdx.get(complement);
                int complementIdx = indices.get(0);

                if (complementIdx != i) {
                    return new int[] { i, complementIdx };
                } else if (indices.size() > 1) {
                    return new int[] { i, indices.get(1) };
                }
            }
        }

        throw new IllegalStateException("shouldn't reach here");
    }
}