package com.john.utils;

import java.util.Map;
import org.junit.Assert;

public class MapAssert {
    public static <K, V> void assertMapEquals(Map<? extends K, ? extends V> expected, Map<? extends K, ? extends V> actual) {
        Assert.assertEquals("map sizes are different", expected.size(), actual.size());

        for (K expectedKey : expected.keySet()) {
            Assert.assertTrue("actual does not contain key " + expectedKey, actual.containsKey(expectedKey));
            Assert.assertEquals("actual value different for key " + expectedKey, expected.get(expectedKey), actual.get(expectedKey));
        }
    }
}
