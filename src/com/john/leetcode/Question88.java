package com.john.leetcode;

public class Question88 {

    public static void main(String[] args) {

        int[] nums1 = { 1, 3, 5, 7, 8, 9, 0, 0, 0, 0, 0 };
        int m = 6;
        int[] nums2 = { 2, 4, 6 };
        int n = 3;
        new Question88().merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + ",");
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        m--;
        n--;
        int idx = m + n + 1;
        while (m >= 0 && n >= 0) {
            int num;
            if (nums1[m] > nums2[n]) {
                num = nums1[m--];
            } else {
                num = nums2[n--];
            }
            nums1[idx--] = num;
        }

        while (m >= 0) {
            nums1[idx--] = nums1[m--];
        }
        while (n >= 0) {
            nums1[idx--] = nums2[n--];
        }
    }

}
