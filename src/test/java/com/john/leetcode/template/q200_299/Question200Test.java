package com.john.leetcode.template.q200_299;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question200Test {
    private Question200 classUnderTest = new Question200();

    @Test
    public void testExample1() {
        char[][] grid = CollectionCreator.create2DArrayChar(
            "[[1,1,1,1,0]," +
                "[1,1,0,1,0]," +
                "[1,1,0,0,0]," +
                "[0,0,0,0,0]]");
        int expected = 1;
        Assert.assertEquals(expected, classUnderTest.numIslands(grid));
    }

    @Test
    public void testExample2() {
        char[][] grid = CollectionCreator.create2DArrayChar(
            "[[1,1,0,0,0]," +
                "[1,1,0,0,0]," +
                "[0,0,1,0,0]," +
                "[0,0,0,1,1]]");
        int expected = 3;
        Assert.assertEquals(expected, classUnderTest.numIslands(grid));
    }
}
