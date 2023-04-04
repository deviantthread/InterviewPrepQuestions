package com.john.Nov2022.leetcode.q200_299;

public class Question238 {
    public int[] productExceptSelf(int[] nums) {
        if (nums.length < 2) {
            return nums;
        }

        int[] leftProducts = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int prevProduct = getValue(i - 1, leftProducts);
            int prevIndex = getValue(i - 1, nums);

            leftProducts[i] = prevProduct * prevIndex;
        }

        int[] rightProducts = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            int prevProduct = getValue(i + 1, rightProducts);
            int prevIndex = getValue(i + 1, nums);

            rightProducts[i] = prevProduct * prevIndex;
        }

        int[] products = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            products[i] = leftProducts[i] * rightProducts[i];
        }

        return products;
    }

    private int getValue(int i, int[] nums) {
        if (i < 0 || i >= nums.length) {
            return 1;
        } else {
            return nums[i];
        }
    }
}
