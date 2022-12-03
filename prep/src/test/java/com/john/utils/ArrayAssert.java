package com.john.utils;

import org.junit.Assert;

public class ArrayAssert {
    public static void assertFirstKElementsEqual(int[] nums, int[] expectedNums, int k) {
        for (int i = 0; i < k; i++) {
            Assert.assertEquals("different at index: " + i, expectedNums[i], nums[i]);
        }
    }
}
