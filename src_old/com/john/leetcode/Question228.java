package com.john.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question228 {

    public static void main(String[] args) {
        int[] nums = {};
        List<String> summaryRanges = new Question228().summaryRanges(nums);
        for (String range : summaryRanges) {
            System.out.print(range + ",");
        }
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<String>();
        if (nums.length == 0) {
            return ret;
        }
        int start = 0;
        int end = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] + 1 == nums[i]) {
                end = i;
            } else {
                if (start == end) {
                    ret.add(String.valueOf(nums[start]));
                } else {
                    ret.add(nums[start] + "->" + nums[end]);
                }
                start = end = i;
            }
        }

        if (start == end) {
            ret.add(String.valueOf(nums[start]));
        } else {
            ret.add(nums[start] + "->" + nums[end]);
        }

        return ret;
    }

}
