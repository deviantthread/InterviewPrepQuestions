package com.john.utils;

import java.util.Arrays;
import java.util.Comparator;
import org.junit.Assert;

public class ArrayAssert {
    public static void assertFirstKElementsEqual(int[] nums, int[] expectedNums, int k) {
        for (int i = 0; i < k; i++) {
            Assert.assertEquals("different at index: " + i, expectedNums[i], nums[i]);
        }
    }

    public static <T> void assertSortedEquals(T[] expected, T[] actual, Comparator<T> c) {
        Arrays.sort(expected, c);
        Arrays.sort(actual, c);

        Assert.assertArrayEquals(expected, actual);
    }
}
