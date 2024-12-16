package com.john.leetcode.Dec2024.q1_99;

import java.util.Arrays;

public class Question16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestDistance = Integer.MAX_VALUE;
        int closestSum = Integer.MAX_VALUE;
        for (int fixedIdx = 0; fixedIdx < nums.length; fixedIdx++) {
            int sum = findClosestTwoSum(nums, fixedIdx, target);
            int distance = Math.abs(Math.abs(target) - Math.abs(sum));
            if (distance == 0) {
                return sum;
            }
            if (distance < closestDistance) {
                closestDistance = distance;
                closestSum = sum;
            }
        }

        return closestSum;
    }

    private int findClosestTwoSum(int[] nums, int fixedIdx, int target) {
        int left = 0;
        int right = nums.length - 1;
        int closestDistance = Integer.MAX_VALUE;
        int closestSum = 0;
        while (left < right) {
            if (left == fixedIdx) {
                left++;
                continue;
            }
            if (right == fixedIdx) {
                right--;
                continue;
            }
            int sum = nums[fixedIdx] + nums[left] + nums[right];
            int distance = Math.abs(Math.abs(target) - Math.abs(sum));

            if (distance < closestDistance) {
                closestDistance = distance;
                closestSum = sum;
            }
            if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return closestSum;
    }
}
