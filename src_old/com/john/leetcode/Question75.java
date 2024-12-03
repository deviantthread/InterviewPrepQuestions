package com.john.leetcode;

public class Question75 {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 0, 1, 2, 2, 2, 2, 1, 1, 0, 0, 0, 1 };
        CollUtils.print(nums, "before");
        new Question75().sortColors(nums);
        CollUtils.print(nums, "sorted");
    }

    public void sortColors(int[] nums) {
        if (nums.length < 2) {
            return;
        }

        int[] ans = mergeSort(nums, 0, nums.length - 1);

        for (int i = 0; i < nums.length; i++) {
            nums[i] = ans[i];
        }
    }

    private int[] mergeSort(int[] nums, int start, int end) {
        if (start == end) {
            return new int[] { nums[start] };
        } else if (end - start == 1) {
            int a = nums[start];
            int b = nums[end];
            if (a < b) {
                return new int[] { a, b };
            } else {
                return new int[] { b, a };
            }
        }

        int mid = (start + end) / 2;
        int[] ary1 = mergeSort(nums, start, mid);
        int[] ary2 = mergeSort(nums, mid + 1, end);

        int[] ans = merge(ary1, ary2);

        return ans;
    }

    private int[] merge(int[] ary1, int[] ary2) {
        int[] ans = new int[ary1.length + ary2.length];

        int i = 0;
        int j = 0;
        int idx = 0;

        while (i < ary1.length && j < ary2.length) {
            if (ary1[i] < ary2[j]) {
                ans[idx++] = ary1[i++];
            } else {
                ans[idx++] = ary2[j++];
            }
        }

        while (i < ary1.length) {
            ans[idx++] = ary1[i++];
        }

        while (j < ary2.length) {
            ans[idx++] = ary2[j++];
        }

        return ans;
    }

}
