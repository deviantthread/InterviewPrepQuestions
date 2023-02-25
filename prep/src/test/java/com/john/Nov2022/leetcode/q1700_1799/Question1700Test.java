package com.john.Nov2022.leetcode.q1700_1799;

import com.john.leetcode.inputhelp.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question1700Test {
    private final Question1700 classUnderTest = new Question1700();

    @Test
    public void testExample1() {
        int[] students = CollectionCreator.createArrayInt("[1,1,0,0]");
        int[] sandwiches = CollectionCreator.createArrayInt("[0,1,0,1]");
        int expected = 0;

        Assert.assertEquals(expected, classUnderTest.countStudents(students, sandwiches));
        //    Explanation:
        //        - Front student leaves the top sandwich and returns to the end of the line making students = [1,0,0,1].
        //        - Front student leaves the top sandwich and returns to the end of the line making students = [0,0,1,1].
        //        - Front student takes the top sandwich and leaves the line making students = [0,1,1] and sandwiches = [1,0,1].
        //        - Front student leaves the top sandwich and returns to the end of the line making students = [1,1,0].
        //        - Front student takes the top sandwich and leaves the line making students = [1,0] and sandwiches = [0,1].
        //        - Front student leaves the top sandwich and returns to the end of the line making students = [0,1].
        //        - Front student takes the top sandwich and leaves the line making students = [1] and sandwiches = [1].
        //        - Front student takes the top sandwich and leaves the line making students = [] and sandwiches = [].
        //    Hence all students are able to eat.
    }

    @Test
    public void testExample2() {
        int[] students = CollectionCreator.createArrayInt("[1,1,1,0,0,1]");
        int[] sandwiches = CollectionCreator.createArrayInt("[1,0,0,0,1,1]");
        int expected = 3;

        Assert.assertEquals(expected, classUnderTest.countStudents(students, sandwiches));
    }
}
