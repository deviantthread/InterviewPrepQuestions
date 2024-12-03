package com.john.leetcode.Nov2022.q1000_1099;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question1046Test {
    private final Question1046 classUnderTest = new Question1046();

    @Test
    public void testExample1() {
        int[] stones = CollectionCreator.createArrayInt("[2,7,4,1,8,1]");
        int expected = 1;
        //    Explanation:
        //    We combine 7 and 8 to get 1 so the array converts to [2,4,1,1,1] then,
        //    we combine 2 and 4 to get 2 so the array converts to [2,1,1,1] then,
        //    we combine 2 and 1 to get 1 so the array converts to [1,1,1] then,
        //    we combine 1 and 1 to get 0 so the array converts to [1] then that's the value of the last stone.
        Assert.assertEquals(expected, classUnderTest.lastStoneWeight(stones));
    }

    @Test
    public void testExample2() {
        int[] stones = CollectionCreator.createArrayInt("[1]");
        int expected = 1;
        Assert.assertEquals(expected, classUnderTest.lastStoneWeight(stones));
    }
}
