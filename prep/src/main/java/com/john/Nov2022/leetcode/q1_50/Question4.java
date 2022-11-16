package com.john.Nov2022.leetcode.q1_50;

public class Question4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * have external index mapper that can map an external index to internal indexes.  ie
         * external index range goes from 0 to nums1.length + nums2.length - 1
         *
         * then use the external index to binary search the two arrays to find the median value
         */

        int lower = 0;
        int upper = nums1.length + nums2.length - 1;

        return findMedian(lower, upper, nums1, nums2);
    }

    private double findMedian(int lower, int upper, int[] nums1, int[] nums2) {
        return 0;
    }
}
