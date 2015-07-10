package com.john.leetcode;

public class Question80 {

    public static void main(String[] args) {

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int skips = 0;
        int to = 1;
        int currCount = 1;
        for (int from = 1; from < nums.length; from++) {
            if (nums[from] == nums[from - 1]) {
                currCount++;
            } else {
                currCount = 1;
            }

            if (currCount <= 2) {
                nums[to++] = nums[from];
            } else {
                skips++;
            }
        }

        return nums.length - skips;
    }
}
