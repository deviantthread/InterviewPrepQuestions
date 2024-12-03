package com.john.leetcode.template.q1300_1399;

public class Question1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if (k <= 0) {
            return 0;
        }

        int left = 0;
        int right = k - 1; // set the window right
        int currSum = 0;
        int ret = 0;

        // add the first few numbers that right skipped over
        for (int i = 0; i < right; i++) {
            currSum += arr[i];
        }

        // keep sliding the window, adding right, removing left, checking if the average is over threshold
        while (right < arr.length) {
            currSum += arr[right];

            if (currSum / (double) k >= threshold) {
                ret++;
            }

            currSum -= arr[left];
            right++;
            left++;
        }

        return ret;
    }
}
