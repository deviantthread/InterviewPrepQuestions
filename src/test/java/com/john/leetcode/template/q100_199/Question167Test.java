package com.john.leetcode.template.q100_199;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question167Test {
    private Question167 classUnderTest = new Question167();

    @Test
    public void testExample1() {
        int[] numbers = CollectionCreator.createArrayInt("[2,7,11,15]");
        int target = 9;
        int[] expected = CollectionCreator.createArrayInt("[1,2]");
        //    Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
        Assert.assertArrayEquals(expected, classUnderTest.twoSum(numbers, target));
    }

    @Test
    public void testExample2() {
        int[] numbers = CollectionCreator.createArrayInt("[2,3,4]");
        int target = 6;
        int[] expected = CollectionCreator.createArrayInt("[1,3]");
        //    Explanation: The sum of 2 and 4 is 6. Therefore index1 = 1, index2 = 3. We return [1, 3].
        Assert.assertArrayEquals(expected, classUnderTest.twoSum(numbers, target));
    }

    @Test
    public void testExample3() {
        int[] numbers = CollectionCreator.createArrayInt("[-1,0]");
        int target = -1;
        int[] expected = CollectionCreator.createArrayInt("[1,2]");
        //    Explanation: The sum of -1 and 0 is -1. Therefore index1 = 1, index2 = 2. We return [1, 2].
        Assert.assertArrayEquals(expected, classUnderTest.twoSum(numbers, target));
    }
}
