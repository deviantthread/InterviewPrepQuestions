package com.john.leetcode.Dec2024.q1_99;

import com.john.leetcode.Dec2024.q900_999.Question912Test;
import com.john.utils.CollectionCreator;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class Question11Test {
    private final Question11 classUnderTest = new Question11();

    @Test
    public void testExample1() {
        int[] height = CollectionCreator.createArrayInt("[1,8,6,2,5,4,8,3,7]");
        int expected = 49;
        Assert.assertEquals(expected, classUnderTest.maxArea(height));
        //    Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
    }

    @Test
    public void testExample2() {
        int[] height = CollectionCreator.createArrayInt("[1,1]");
        int expected = 1;
        Assert.assertEquals(expected, classUnderTest.maxArea(height));
    }

    @Test
    public void testExample3() throws IOException {
        InputStream numsStream = Question912Test.class.getClassLoader().getResourceAsStream("leetcode/Question11_large_input.txt");

        String numsStr = IOUtils.toString(numsStream, Charset.defaultCharset());

        int[] height = CollectionCreator.createArrayInt(numsStr);
        int expected = 721777500;
        Assert.assertEquals(expected, classUnderTest.maxArea(height));
    }
}