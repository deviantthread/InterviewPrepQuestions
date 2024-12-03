package com.john.Nov2022.leetcode.q1_99;

import org.junit.Assert;
import org.junit.Test;

public class Question37Test {
    private Question37 classUnderTest = new Question37();

    @Test
    public void testExample1() {

        char[][] board = {
            { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
            { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
            { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
            { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
            { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
            { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
            { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
            { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
            { '.', '.', '.', '.', '8', '.', '.', '7', '9' }
        };
        char[][] expected = {
            { '5', '3', '4', '6', '7', '8', '9', '1', '2' },
            { '6', '7', '2', '1', '9', '5', '3', '4', '8' },
            { '1', '9', '8', '3', '4', '2', '5', '6', '7' },
            { '8', '5', '9', '7', '6', '1', '4', '2', '3' },
            { '4', '2', '6', '8', '5', '3', '7', '9', '1' },
            { '7', '1', '3', '9', '2', '4', '8', '5', '6' },
            { '9', '6', '1', '5', '3', '7', '2', '8', '4' },
            { '2', '8', '7', '4', '1', '9', '6', '3', '5' },
            { '3', '4', '5', '2', '8', '6', '1', '7', '9' }
        };
        //    Explanation: The input board is shown above and the only valid solution is shown below:

        classUnderTest.solveSudoku(board);
        for (int row = 0; row < board.length; row++) {
            Assert.assertArrayEquals("row " + row, expected[row], board[row]);
        }
    }
}
