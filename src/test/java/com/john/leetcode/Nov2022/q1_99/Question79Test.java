package com.john.leetcode.Nov2022.q1_99;

import com.john.utils.CollectionCreator;
import org.junit.Assert;
import org.junit.Test;

public class Question79Test {
    private Question79 classUnderTest = new Question79();

    @Test
    public void testExample1() {
        char[][] board = CollectionCreator.create2DArrayChar("[[A,B,C,E],[S,F,C,S],[A,D,E,E]]");
        String word = "ABCCED";
        boolean expected = true;
        Assert.assertEquals(expected, classUnderTest.exist(board, word));
    }

    @Test
    public void testExample2() {
        char[][] board = CollectionCreator.create2DArrayChar("[[A,B,C,E],[S,F,C,S],[A,D,E,E]]");
        String word = "SEE";
        boolean expected = true;
        Assert.assertEquals(expected, classUnderTest.exist(board, word));
    }

    @Test
    public void testExample3() {
        char[][] board = CollectionCreator.create2DArrayChar("[[A,B,C,E],[S,F,C,S],[A,D,E,E]]");
        String word = "ABCB";
        boolean expected = false;
        Assert.assertEquals(expected, classUnderTest.exist(board, word));
    }
}
