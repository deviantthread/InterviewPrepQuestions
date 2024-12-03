package com.john.Nov2022.leetcode.q100_199;

public class Question167 {
    public int[] twoSum(int[] numbers, int target) {
        int[] ret = new int[2];

        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int curr = numbers[left] + numbers[right];
            if (curr == target) {
                ret[0] = left + 1;
                ret[1] = right + 1;
                break;
            } else if (curr < target) {
                left++;
            } else {
                right--;
            }
        }

        return ret;
    }
}
