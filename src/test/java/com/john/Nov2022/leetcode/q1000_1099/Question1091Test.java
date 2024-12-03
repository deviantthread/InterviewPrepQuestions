package com.john.Nov2022.leetcode.q1000_1099;

import com.john.leetcode.inputhelp.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question1091Test {
    private final Question1091 classUnderTest = new Question1091();

    @Test
    public void testExample1() {
        int[][] grid = CollectionCreator.create2DArrayInt("[[0,1],[1,0]]");
        int expected = 2;
        Assert.assertEquals(expected, classUnderTest.shortestPathBinaryMatrix(grid));
    }

    @Test
    public void testExample2() {
        int[][] grid = CollectionCreator.create2DArrayInt("[[0,0,0],[1,1,0],[1,1,0]]");
        int expected = 4;
        Assert.assertEquals(expected, classUnderTest.shortestPathBinaryMatrix(grid));
    }

    @Test
    public void testExample3() {
        int[][] grid = CollectionCreator.create2DArrayInt("[[1,0,0],[1,1,0],[1,1,0]]");
        int expected = -1;
        Assert.assertEquals(expected, classUnderTest.shortestPathBinaryMatrix(grid));
    }

    @Test
    public void testExample4() {
        int[][] grid = CollectionCreator.create2DArrayInt("[[0,0,0],[1,1,0],[1,1,1]]");
        int expected = -1;
        Assert.assertEquals(expected, classUnderTest.shortestPathBinaryMatrix(grid));
    }
}
