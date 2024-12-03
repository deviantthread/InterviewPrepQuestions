package com.john.leetcode.Nov2022.q1_99;

public class Question11 {
    public int maxArea(int[] height) {
        int maxArea = 0;

        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int heightBound = Math.min(height[left], height[right]);
            int width = right - left;
            maxArea = Math.max(maxArea, heightBound * width);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public int maxAreaBruteForce(int[] height) {

        int maxArea = 0;

        for (int left = 0; left < height.length; left++) {
            for (int right = left + 1; right < height.length; right++) {
                int heightBound = Math.min(height[left], height[right]);
                int width = right - left;
                maxArea = Math.max(maxArea, heightBound * width);
            }
        }

        return maxArea;
    }
}
