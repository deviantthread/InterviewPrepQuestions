package com.john.utils;

import java.util.List;
import org.junit.Assert;

public class ListAssert {
    public static void assertListEquals(List<Integer> expected, List<Integer> actual) {
        Assert.assertArrayEquals(expected.toArray(new Integer[0]), actual.toArray(new Integer[0]));
    }
}
