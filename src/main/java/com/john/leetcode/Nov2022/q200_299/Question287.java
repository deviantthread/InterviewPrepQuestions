package com.john.leetcode.Nov2022.q200_299;

import java.util.HashSet;
import java.util.Set;

public class Question287 {
    public int findDuplicate(int[] nums) {
        Set<Integer> seenNums = new HashSet<>();

        for (int num : nums) {
            if (seenNums.contains(num)) {
                return num;
            } else {
                seenNums.add(num);
            }
        }

        return -1;
    }
}
