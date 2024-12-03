package com.john.leetcode.Nov2022.q200_299;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Question217 {
    public boolean containsDuplicate(int[] nums) {
        return Arrays.stream(nums)
            .mapToObj(i -> i)
            .collect(Collectors.toSet())
            .size() != nums.length;
    }
}
