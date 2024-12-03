package com.john.leetcode.template.q900_999;

import com.john.utils.CollectionCreator;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import org.apache.commons.io.IOUtils;
import org.junit.Assert;
import org.junit.Test;

public class Question912Test {
    private final Question912 classUnderTest = new Question912();

    @Test
    public void testExample1() {
        int[] nums = CollectionCreator.createArrayInt("[5,2,3,1]");
        int[] expected = CollectionCreator.createArrayInt("[1,2,3,5]");
        //    Explanation: After sorting the array, the positions of some numbers are not changed (for example, 2 and 3), while the positions of other numbers are changed (for example, 1 and 5).
        Assert.assertArrayEquals(expected, classUnderTest.sortArray(nums));
    }

    @Test
    public void testExample2() {
        int[] nums = CollectionCreator.createArrayInt("[5,1,1,2,0,0]");
        int[] expected = CollectionCreator.createArrayInt("[0,0,1,1,2,5]");
        //    Explanation: Note that the values of nums are not necessarily unique.
        Assert.assertArrayEquals(expected, classUnderTest.sortArray(nums));
    }

    @Test
    public void testExample3() throws IOException {
        InputStream numsStream = Question912Test.class.getClassLoader().getResourceAsStream("leetcode/Question912_large_input.txt");

        String numsStr = IOUtils.toString(numsStream);
        int[] nums = CollectionCreator.createArrayInt(numsStr);
        int[] numsSorted = CollectionCreator.createArrayInt(numsStr);
        Arrays.sort(numsSorted);

        Assert.assertArrayEquals(numsSorted, classUnderTest.sortArray(nums));
    }
}
