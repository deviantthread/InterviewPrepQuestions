package com.john.utils;

import java.util.List;
import org.junit.Assert;

public class ListAssert {
    public static void assertListEquals(List<?> expected, List<?> actual) {
        Assert.assertArrayEquals(expected.toArray(new Object[0]), actual.toArray(new Object[0]));
    }
}
