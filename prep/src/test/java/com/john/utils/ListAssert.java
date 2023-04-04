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

    public static void assertSortedListStringEquals(List<String> expected, List<String> actual) {
        expected.sort(String::compareTo);
        actual.sort(String::compareTo);
        ArrayAssert.assertSortedEquals(expected.toArray(new Object[0]), actual.toArray(new Object[0]), Comparator.comparing(o -> o.hashCode()));
    }

    public static final Comparator<List<Integer>> LIST_INT_COMPARATOR = (l1, l2) -> {
        if (l1.size() != l2.size()) {
            return Integer.compare(l1.size(), l2.size());
        } else {
            return Integer.compare(l1.stream().reduce(0, Integer::sum), l2.stream().reduce(0, Integer::sum));
        }
    };
}
