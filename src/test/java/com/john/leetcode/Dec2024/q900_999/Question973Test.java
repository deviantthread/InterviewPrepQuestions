package com.john.leetcode.Dec2024.q900_999;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question973Test {
    private final Question973 classUnderTest = new Question973();

    @Test
    public void testExample1() {
        int[][] points = CollectionCreator.create2DArrayInt("[[1,3],[-2,2]]");
        int k = 1;
        int[][] expected = CollectionCreator.create2DArrayInt("[[-2,2]]");
        Assert.assertArrayEquals(expected, classUnderTest.kClosest(points, k));
        //    Explanation:
        //    The distance between (1, 3) and the origin is sqrt(10).
        //    The distance between (-2, 2) and the origin is sqrt(8).
        //    Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
        //    We only want the closest k = 1 points from the origin, so the answer is just [[-2,2]].
    }

    @Test
    public void testExample2() {
        int[][] points = CollectionCreator.create2DArrayInt("[[3,3],[5,-1],[-2,4]]");
        int k = 2;
        int[][] expected = CollectionCreator.create2DArrayInt("[[3,3],[-2,4]]");
        Assert.assertArrayEquals(expected, classUnderTest.kClosest(points, k));
        //    Explanation: The answer [[-2,4],[3,3]] would also be accepted.
    }
}
