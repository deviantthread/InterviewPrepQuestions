package com.john.leetcode.template.q200_299;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question207Test {
    private final Question207 classUnderTest = new Question207();

    @Test
    public void testExample1() {
        int numCourses = 2;
        int[][] prerequisites = CollectionCreator.create2DArrayInt("[[1,0]]");
        boolean expected = true;
        //    Explanation: There are a total of 2 courses to take.
        //    To take course 1 you should have finished course 0. So it is possible.
        Assert.assertEquals(expected, classUnderTest.canFinish(numCourses, prerequisites));
    }

    @Test
    public void testExample2() {
        int numCourses = 2;
        int[][] prerequisites = CollectionCreator.create2DArrayInt("[[1,0],[0,1]]");
        boolean expected = false;
        //    Explanation: There are a total of 2 courses to take.
        //    To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
        Assert.assertEquals(expected, classUnderTest.canFinish(numCourses, prerequisites));
    }
}
