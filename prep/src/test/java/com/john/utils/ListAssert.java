package com.john.utils;

import java.util.List;
import org.junit.Assert;

public class ListAssert {
    public static void assertListEquals(List<?> expected, List<?> actual) {
        Assert.assertArrayEquals(expected.toArray(new Object[0]), actual.toArray(new Object[0]));
    }

    public static void assertListEqualsInt(List<Integer> expected, List<Integer> actual) {
        Assert.assertArrayEquals(expected.toArray(new Integer[0]), actual.toArray(new Integer[0]));
    }

    public static void assertListEqualsString(List<String> expected, List<String> actual) {
        Assert.assertArrayEquals(expected.toArray(new String[0]), actual.toArray(new String[0]));
    }
}
