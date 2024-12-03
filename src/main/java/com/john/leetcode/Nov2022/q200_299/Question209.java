package com.john.leetcode.Nov2022.q200_299;

public class Question209 {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int currSum = nums[0];
        int currLen = 1;
        int minLen = nums.length + 1;

        while (left < nums.length) {
            if (currSum >= target) {
                minLen = Math.min(minLen, currLen);

                //can we shrink?
                if (left < right) {
                    currSum -= nums[left];
                    left++;
                    currLen--;
                } else {
                    //no choice but to expand
                    if (right < nums.length - 1) {
                        right++;
                        currSum += nums[right];
                        currLen++;
                    } else {
                        // we can't expand, and we can't shrink
                        break;
                    }
                }
            } else {
                // window too small, expand
                if (right < nums.length - 1) {
                    right++;
                    currSum += nums[right];
                    currLen++;
                } else {
                    //window too small and we can't expand, break
                    break;
                }
            }
        }

        if (minLen == nums.length + 1) {
            minLen = 0;
        }

        return minLen;
    }
}
