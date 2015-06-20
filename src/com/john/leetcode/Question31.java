package com.john.leetcode;

import java.util.Arrays;

public class Question31 {

    public static void main(String[] args) {
        int[] nums = { 3, 3 };
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println();

        new Question31().nextPermutation(nums);

        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        } else if (nums.length == 2) {
            swapI(nums, 0);
            return;
        } else if (isHighestNumber(nums, 0)) {
            sortAfterI(nums, -1);
            return;
        }

        int i = nums.length - 2;
        for (; i >= 0; i--) {
            if (!isHighestNumber(nums, i)) {
                i--;
                break;
            }
        }

        i++;

        swapI(nums, i);

        sortAfterI(nums, i);
    }

    private void sortAfterI(int[] nums, int i) {
        Arrays.sort(nums, i + 1, nums.length);
    }

    private void swapI(int[] nums, int i) {
        int iVal = nums[i];
        int lowestOverI = Integer.MAX_VALUE;
        int lowestX = -1;

        for (int x = i + 1; x < nums.length; x++) {
            if (nums[x] > iVal) {
                if (lowestOverI > nums[x]) {
                    lowestX = x;
                    lowestOverI = nums[x];
                }
            }
        }
        if (lowestX != -1) {
            nums[i] = nums[lowestX];
            nums[lowestX] = iVal;
        }
    }

    private boolean isHighestNumber(int[] nums, int start) {
        int prev = Integer.MAX_VALUE;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] > prev) {
                return false;
            }
            prev = nums[i];
        }

        return true;
    }
}
