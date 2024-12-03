package com.john.leetcode.Dec2024.q1300_1399;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question1343Test {
    private final Question1343 classUnderTest = new Question1343();

    @Test
    public void testExample1() {
        int[] arr = CollectionCreator.createArrayInt("[2,2,2,2,5,5,5,8]");
        int k = 3;
        int threshold = 4;
        int expected = 3;
        //    Explanation: Sub-arrays [2,5,5],[5,5,5] and [5,5,8] have averages 4, 5 and 6 respectively. All other sub-arrays of size 3 have averages less than 4 (the threshold).
        Assert.assertEquals(expected, classUnderTest.numOfSubarrays(arr, k, threshold));
    }

    @Test
    public void testExample2() {
        int[] arr = CollectionCreator.createArrayInt("[11,13,17,23,29,31,7,5,2,3]");
        int k = 3;
        int threshold = 5;
        int expected = 6;
        //    Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
        Assert.assertEquals(expected, classUnderTest.numOfSubarrays(arr, k, threshold));
    }

    @Test
    public void testExample3() {
        int[] arr = CollectionCreator.createArrayInt("[1,1,1,1,1]");
        int k = 1;
        int threshold = 0;
        int expected = 5;
        //    Explanation: The first 6 sub-arrays of size 3 have averages greater than 5. Note that averages are not integers.
        Assert.assertEquals(expected, classUnderTest.numOfSubarrays(arr, k, threshold));
    }
}
