package com.john.leetcode.Nov2022.q1_99;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Question1 {
    public int[] twoSumHashMap(int[] nums, int target) {
        Map<Integer, Integer> valueToIdx = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (valueToIdx.containsKey(target - nums[i])) {
                return new int[] { i, valueToIdx.get(target - nums[i]) };
            }

            valueToIdx.put(nums[i], i);
        }

        return null;
    }

    public int[] twoSumBinarySearch(int[] nums, int target) {
        int lower = 0;
        int upper = nums.length - 1;
        Orig[] origs = new Orig[nums.length];
        for (int i = 0; i < nums.length; i++) {
            origs[i] = new Orig(nums[i], i);
        }

        Comparator<Orig> comparator = Comparator.comparing(c -> c.value);
        Arrays.sort(origs, comparator);

        for (int i = 0; i < origs.length; i++) {
            int idx = Arrays.binarySearch(origs, new Orig(target - origs[i].value, -1), comparator);
            if (idx >= 0 && origs[i].origIdx != origs[idx].origIdx) {
                return new int[] { origs[i].origIdx, origs[idx].origIdx };
            }
        }
        return null;
    }

    private static class Orig {
        int value;
        int origIdx;

        public Orig(int value, int origIdx) {
            this.value = value;
            this.origIdx = origIdx;
        }
    }
}
