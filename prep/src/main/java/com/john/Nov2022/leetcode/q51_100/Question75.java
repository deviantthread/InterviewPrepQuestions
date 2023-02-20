package com.john.Nov2022.leetcode.q51_100;

public class Question75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        mergeSort(nums, 0, nums.length - 1);
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (right - left <= 1) {
            if (nums[left] > nums[right]) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid - 1);
        mergeSort(nums, mid, right);

        int[] merged = new int[right - left + 1];
        int mergedIdx = 0;
        int leftIdx = left;
        int rightIdx = mid;

        while (leftIdx <= mid - 1 && rightIdx <= right) {
            if (nums[leftIdx] < nums[rightIdx]) {
                merged[mergedIdx++] = nums[leftIdx++];
            } else {
                merged[mergedIdx++] = nums[rightIdx++];
            }
        }

        while (leftIdx <= mid - 1) {
            merged[mergedIdx++] = nums[leftIdx++];
        }

        while (rightIdx <= right) {
            merged[mergedIdx++] = nums[rightIdx++];
        }

        // now put it back on nums
        for (int i = 0; i < merged.length; i++) {
            nums[left++] = merged[i];
        }
    }

    public void sortColorsFast(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }

        int[] colors = new int[3];

        for (int num : nums) {
            colors[num]++;
        }

        int numIdx = 0;
        for (int color = 0; color < colors.length; color++) {
            while (colors[color]-- > 0) {
                nums[numIdx++] = color;
            }
        }
    }
}
