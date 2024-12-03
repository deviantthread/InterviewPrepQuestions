package com.john.Nov2022.leetcode.q1_99;

import com.john.leetcode.inputhelp.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question73Test {
    private Question73 classUnderTest = new Question73();

    @Test
    public void testExample1() {
        int[][] matrix = CollectionCreator.create2DArrayInt("[[1,1,1],[1,0,1],[1,1,1]]");
        int[][] expected = CollectionCreator.create2DArrayInt("[[1,0,1],[0,0,0],[1,0,1]]");

        classUnderTest.setZeroes(matrix);
        Assert.assertArrayEquals(expected, matrix);
    }

    @Test
    public void testExample2() {
        int[][] matrix = CollectionCreator.create2DArrayInt("[[0,1,2,0],[3,4,5,2],[1,3,1,5]]");
        int[][] expected = CollectionCreator.create2DArrayInt("[[0,0,0,0],[0,4,5,0],[0,3,1,0]]");

        classUnderTest.setZeroes(matrix);
        Assert.assertArrayEquals(expected, matrix);
    }
}
