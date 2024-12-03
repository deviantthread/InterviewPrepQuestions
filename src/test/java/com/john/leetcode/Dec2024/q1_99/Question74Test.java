package com.john.leetcode.Dec2024.q1_99;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question74Test {
    private Question74 classUnderTest = new Question74();

    @Test
    public void testExample1() {
        int[][] matrix = CollectionCreator.create2DArrayInt("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]");
        int target = 3;
        boolean expected = true;
        Assert.assertEquals(expected, classUnderTest.searchMatrix(matrix, target));
    }

    @Test
    public void testExample2() {
        int[][] matrix = CollectionCreator.create2DArrayInt("[[1,3,5,7],[10,11,16,20],[23,30,34,60]]");
        int target = 13;
        boolean expected = false;
        Assert.assertEquals(expected, classUnderTest.searchMatrix(matrix, target));
    }

    @Test
    public void testExample3() {
        int[][] matrix = CollectionCreator.create2DArrayInt("[[1,3,5,7],[10,11,16,20],[23,30,34,50]]");
        int target = 11;
        boolean expected = true;
        Assert.assertEquals(expected, classUnderTest.searchMatrix(matrix, target));
    }
}
