package com.john.leetcode.template.q600_699;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question695Test {
    private final Question695 classUnderTest = new Question695();

    @Test
    public void testExample1() {
        int[][] grid = CollectionCreator.create2DArrayInt("[[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]");
        int expected = 6;
        Assert.assertEquals(expected, classUnderTest.maxAreaOfIsland(grid));
        //    Explanation: The answer is not 11, because the island must be connected 4-directionally.
    }

    @Test
    public void testExample2() {
        int[][] grid = CollectionCreator.create2DArrayInt("[[0,0,0,0,0,0,0,0]]");
        int expected = 0;
        Assert.assertEquals(expected, classUnderTest.maxAreaOfIsland(grid));
    }
}
