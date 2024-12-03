package com.john.leetcode.Nov2022.q700_799;

import com.john.leetcode.Nov2022.q700_799.Question702.ArrayReader;
import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question702Test {
    private final Question702 classUnderTest = new Question702();

    @Test
    public void testExample1() {
        int[] secret = CollectionCreator.createArrayInt("[-1,0,3,5,9,12]");
        int target = 9;
        int expected = 4;
        //    Explanation: 9 exists in secret and its index is 4.
        Assert.assertEquals(expected, classUnderTest.search(new ArrayReader(secret), target));
    }

    @Test
    public void testExample2() {
        int[] secret = CollectionCreator.createArrayInt("[-1,0,3,5,9,12]");
        int target = 2;
        int expected = -1;
        //    Explanation: 2 does not exist in secret so return -1.
        Assert.assertEquals(expected, classUnderTest.search(new ArrayReader(secret), target));
    }
}
