package com.john.utils;

import java.util.Comparator;
import java.util.List;
import org.junit.Assert;

public class ListAssert {
    public static void assertListEquals(List<?> expected, List<?> actual) {
        Assert.assertArrayEquals(expected.toArray(new Object[0]), actual.toArray(new Object[0]));
    }

    public static <T> void assertSortedListEquals(List<? extends T> expected, List<? extends T> actual, Comparator<? super T> c) {
        expected.sort(c);
        actual.sort(c);
        ArrayAssert.assertSortedEquals(expected.toArray(new Object[0]), actual.toArray(new Object[0]), Comparator.comparing(o -> o.hashCode()));
    }


}
