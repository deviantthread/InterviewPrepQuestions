package com.john.leetcode.template.q200_299;

import java.util.HashSet;
import java.util.Set;

public class Question219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (k <= 0) {
            return false;
        }
        int left = 0;
        int right = 0;
        Set<Integer> window = new HashSet<>();
        window.add(nums[0]);

        while (right < nums.length - 1) {
            if (Math.abs(right - left) < k && right < nums.length - 1) {
                // expand window
                right++;
                if (window.contains(nums[right])) {
                    return true;
                } else {
                    window.add(nums[right]);
                }
            } else {
                //shrink window
                window.remove(nums[left]);
                left++;
            }
        }

        return false;
    }
}
