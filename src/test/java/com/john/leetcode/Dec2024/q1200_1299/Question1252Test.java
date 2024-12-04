package com.john.leetcode.Dec2024.q1200_1299;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.Test;

public class Question1252Test {
    private final Question1252 classUnderTest = new Question1252();

    @Test
    public void testExample1() {
        int m = 2;
        int n = 3;
        int[][] indices = CollectionCreator.create2DArrayInt("[[0,1],[1,1]]");
        int expected = 6;
        Assert.assertEquals(expected, classUnderTest.oddCells(m, n, indices));
        //    Explanation: Initial matrix = [[0,0,0],[0,0,0]].
        //    After applying first increment it becomes [[1,2,1],[0,1,0]].
        //    The final matrix is [[1,3,1],[1,3,1]], which contains 6 odd numbers.
    }

    @Test
    public void testExample2() {
        int m = 2;
        int n = 2;
        int[][] indices = CollectionCreator.create2DArrayInt("[[1,1],[0,0]]");
        int expected = 0;
        Assert.assertEquals(expected, classUnderTest.oddCells(m, n, indices));
        //    Explanation: Final matrix = [[2,2],[2,2]]. There are no odd numbers in the final matrix.
    }
}
