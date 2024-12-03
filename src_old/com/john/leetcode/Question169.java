package com.john.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Question169 {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 1, 1, 2, 6, 7, 8, 9, 1, 1, 1, 1, 1, 1 };
        System.out.println(new Question169().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

        for (int num : nums) {
            int count = 0;
            if (counts.containsKey(num)) {
                count = counts.get(num);
            }
            counts.put(num, count + 1);
        }

        int maxNum = -1;
        int maxCount = -1;

        for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxNum = entry.getKey();
            }
        }

        return maxNum;
    }
}
