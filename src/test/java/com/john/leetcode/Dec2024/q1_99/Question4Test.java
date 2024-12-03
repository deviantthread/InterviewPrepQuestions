package com.john.leetcode.Dec2024.q1_99;

import org.junit.Assert;
import org.junit.Test;

public class Question4Test {
    private final Question4 question4 = new Question4();

    @Test
    public void testExample1() {
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        double expected = 2.0;

        Assert.assertEquals(expected, question4.findMedianSortedArrays(nums1, nums2), 0.0001);
    }

    @Test
    public void testExample2() {
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        double expected = 2.5;

        Assert.assertEquals(expected, question4.findMedianSortedArrays(nums1, nums2), 0.0001);
    }
}