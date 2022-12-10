package com.john.Nov2022.leetcode.q51_100;

public class Question88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int dst = m + n - 1;
        m--;
        n--;
        while (dst >= 0) {
            // we've reached the end of nums2, break
            if (n < 0) {
                break;
            }
            // reached the end of nums1, copy nums2 over
            if (m < 0) {
                nums1[dst--] = nums2[n--];
            } else if (nums1[m] > nums2[n]) {
                nums1[dst--] = nums1[m--];
            } else {
                nums1[dst--] = nums2[n--];
            }
        }
    }
}
