package com.john.leetcode.Nov2022.q900_999;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question994Test {
    private final Question994 classUnderTest = new Question994();

    @Test
    public void testExample1() {
        int[][] grid = CollectionCreator.create2DArrayInt("[[2,1,1],[1,1,0],[0,1,1]]");
        int expected = 4;
        Assert.assertEquals(expected, classUnderTest.orangesRotting(grid));
    }

    @Test
    public void testExample2() {
        int[][] grid = CollectionCreator.create2DArrayInt("[[2,1,1],[0,1,1],[1,0,1]]");
        int expected = -1;
        Assert.assertEquals(expected, classUnderTest.orangesRotting(grid));
        //    Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
    }

    @Test
    public void testExample3() {
        int[][] grid = CollectionCreator.create2DArrayInt("[[0,2]]");
        int expected = 0;
        Assert.assertEquals(expected, classUnderTest.orangesRotting(grid));
        //    Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
    }
}
