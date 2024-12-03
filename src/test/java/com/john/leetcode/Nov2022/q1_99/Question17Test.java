package com.john.leetcode.Nov2022.q1_99;

import com.google.common.collect.Lists;
import com.john.utils.ListAssert;
import java.util.List;
import org.junit.Test;

public class Question17Test {
    private Question17 classUnderTest = new Question17();

    @Test
    public void testExample1() {
        String digits = "23";
        List<String> expected = Lists.newArrayList("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        ListAssert.assertListEquals(expected, classUnderTest.letterCombinations(digits));
    }

    @Test
    public void testExample2() {
        String digits = "";
        List<String> expected = Lists.newArrayList();
        ListAssert.assertListEquals(expected, classUnderTest.letterCombinations(digits));
    }

    @Test
    public void testExample3() {
        String digits = "2";
        List<String> expected = Lists.newArrayList("a", "b", "c");
        ListAssert.assertListEquals(expected, classUnderTest.letterCombinations(digits));
    }
}
