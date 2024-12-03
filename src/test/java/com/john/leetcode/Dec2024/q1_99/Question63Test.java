package com.john.leetcode.Dec2024.q1_99;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question63Test {
    private Question63 classUnderTest = new Question63();

    @Test
    public void testExample1() {
        int[][] obstacleGrid = CollectionCreator.create2DArrayInt("[[0,0,0],[0,1,0],[0,0,0]]");
        int expected = 2;
        Assert.assertEquals(expected, classUnderTest.uniquePathsWithObstacles(obstacleGrid));
        //    Explanation: There is one obstacle in the middle of the 3x3 grid above.
        //    There are two ways to reach the bottom-right corner:
        //        1. Right -> Right -> Down -> Down
        //2. Down -> Down -> Right -> Right
    }

    @Test
    public void testExample2() {
        int[][] obstacleGrid = CollectionCreator.create2DArrayInt("[[0,1],[0,0]]");
        int expected = 1;
        Assert.assertEquals(expected, classUnderTest.uniquePathsWithObstacles(obstacleGrid));
    }
}
