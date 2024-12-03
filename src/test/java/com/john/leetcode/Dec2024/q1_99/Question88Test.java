package com.john.leetcode.Dec2024.q1_99;

import org.junit.Assert;
import org.junit.Test;

public class Question88Test {
    private Question88 classUnderTest = new Question88();

    @Test
    public void testExample1() {

        int[] nums1 = { 1, 2, 3, 0, 0, 0 };
        int m = 3;
        int[] nums2 = { 2, 5, 6 };
        int n = 3;
        int[] expected = { 1, 2, 2, 3, 5, 6 };
        //    Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
        //    The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
        classUnderTest.merge(nums1, m, nums2, n);
        Assert.assertArrayEquals(expected, nums1);
    }

    @Test
    public void testExample2() {

        int[] nums1 = { 1 };
        int m = 1;
        int[] nums2 = {};
        int n = 0;
        int[] expected = { 1 };
        //    Explanation: The arrays we are merging are [1] and [].
        //    The result of the merge is [1].
        classUnderTest.merge(nums1, m, nums2, n);
        Assert.assertArrayEquals(expected, nums1);
    }

    @Test
    public void testExample3() {

        int[] nums1 = { 0 };
        int m = 0;
        int[] nums2 = { 1 };
        int n = 1;
        int[] expected = { 1 };
        //    Explanation: The arrays we are merging are [] and [1].
        //    The result of the merge is [1].
        classUnderTest.merge(nums1, m, nums2, n);
        Assert.assertArrayEquals(expected, nums1);
        //    Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.}
    }
}