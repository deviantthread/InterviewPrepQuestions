package com.john.leetcode.template.q900_999;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question978Test {
    private final Question978 classUnderTest = new Question978();

    @Test
    public void testExample1() {
        int[] arr = CollectionCreator.createArrayInt("[9,4,2,10,7,8,8,1,9]");
        int expected = 5;
        Assert.assertEquals(expected, classUnderTest.maxTurbulenceSize(arr));
        //    Explanation: arr[1] > arr[2] < arr[3] > arr[4] < arr[5]
    }

    @Test
    public void testExample2() {
        int[] arr = CollectionCreator.createArrayInt("[4,8,12,16]");
        int expected = 2;
        Assert.assertEquals(expected, classUnderTest.maxTurbulenceSize(arr));
    }

    @Test
    public void testExample3() {
        int[] arr = CollectionCreator.createArrayInt("[100]");
        int expected = 1;
        Assert.assertEquals(expected, classUnderTest.maxTurbulenceSize(arr));
    }
}
