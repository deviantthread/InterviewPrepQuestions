package com.john.leetcode.Nov2022.q900_999;

import java.util.Random;

public class Question912 {

    public int[] sortArray(int[] nums) {

        quickSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void quickSort(int[] nums, int left, int right) {
        // already sorted
        if (left >= right) {
            return;
        } else if (right - left == 1) {
            if (nums[left] > nums[right]) {
                swap(nums, left, right);
            }
        }

        //choose a pivot at random
        int bound = right - left;
        int randoIdx = new Random().nextInt(bound) + left;
        swap(nums, right, randoIdx);

        int pivot = nums[right];

        int dst = left;
        int src = left;

        while (src < right) {
            if (nums[src] < pivot) {
                swap(nums, src, dst);
                dst++;
            }

            src++;
        }

        // put the pivot in the right spot
        swap(nums, right, dst);

        quickSort(nums, left, dst - 1);
        quickSort(nums, dst + 1, right);
    }

    private static void swap(int[] nums, int src, int dst) {
        int tmp = nums[src];
        nums[src] = nums[dst];
        nums[dst] = tmp;
    }

    public int[] sortArrayMergeSort(int[] nums) {

        mergeSort(nums, 0, nums.length - 1);

        return nums;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (right - left <= 1) {
            if (nums[left] > nums[right]) {
                swap(nums, left, right);
            }
            return;
        }

        int mid = left + (right - left) / 2;

        mergeSort(nums, left, mid - 1);
        mergeSort(nums, mid, right);

        int[] leftAry = copyOf(nums, left, mid - 1);
        int[] rightAry = copyOf(nums, mid, right);

        merge(nums, left, leftAry, rightAry);
    }

    private static void merge(int[] nums, int left, int[] leftAry, int[] rightAry) {
        int leftIdx = 0;
        int rightIdx = 0;
        int idx = left;

        while (rightIdx < rightAry.length && leftIdx < leftAry.length) {
            if (leftAry[leftIdx] < rightAry[rightIdx]) {
                nums[idx++] = leftAry[leftIdx++];
            } else {
                nums[idx++] = rightAry[rightIdx++];
            }
        }

        while (leftIdx < leftAry.length) {
            nums[idx++] = leftAry[leftIdx++];
        }

        while (rightIdx < rightAry.length) {
            nums[idx++] = rightAry[rightIdx++];
        }
    }

    private int[] copyOf(int[] nums, int left, int right) {
        int[] ret = new int[right - left + 1];

        for (int i = 0; left <= right; i++) {
            ret[i] = nums[left++];
        }

        return ret;
    }

    // insertion sort
    //works but its hella slow
    public int[] sortArrayInsertionSort(int[] nums) {
        for (int idx = 1; idx < nums.length; idx++) {
            for (int swapIdx = idx - 1; swapIdx >= 0 && nums[swapIdx] > nums[swapIdx + 1]; swapIdx--) {
                int tmp = nums[swapIdx];
                nums[swapIdx] = nums[swapIdx + 1];
                nums[swapIdx + 1] = tmp;
            }
        }
        return nums;
    }
}
