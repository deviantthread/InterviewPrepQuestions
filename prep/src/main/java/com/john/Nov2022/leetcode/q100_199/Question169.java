package com.john.Nov2022.leetcode.q100_199;

import java.util.Arrays;

public class Question169 {
    public int majorityElement(int[] nums) {
        return Arrays.stream(nums).sorted()
            .skip(nums.length / 2)
            .findFirst()
            .getAsInt();
    }
}
