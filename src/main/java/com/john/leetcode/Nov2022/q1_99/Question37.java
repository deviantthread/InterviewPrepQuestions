package com.john.leetcode.Nov2022.q1_99;

public class Question37 {
    public void solveSudoku(char[][] board) {
        // i think easiest is to recurse it.
        // put each number in each location assuming its allowed

        solveSudokuRecurse(board);
    }

    private boolean solveSudokuRecurse(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                // its already a digit, leave it
                if (Character.isDigit(board[row][col])) {
                    continue;
                }
                for (int num = 1; num <= 9; num++) {
                    board[row][col] = (char) ('0' + num);

                    boolean foundDuplicate = isDuplicateInRow(board, row, col) ||
                        isDuplicateInCol(board, row, col) ||
                        isDuplicateInBox(board, row, col);

                    // its good as far as we know, try to recurse
                    if (!foundDuplicate) {
                        boolean recurseSuccessful = solveSudokuRecurse(board);
                        if (recurseSuccessful) {
                            return recurseSuccessful; // yay!
                        }
                    }
                }

                // we've tried all the numbers and none of them work, reset it and fail
                board[row][col] = '.';
                return false;
            }
        }

        // we got to the end of the board
        return true;
    }

    private boolean isDuplicateInRow(char[][] board, int row, int col) {
        char target = board[row][col];
        for (int rowIdx = 0; rowIdx < board.length; rowIdx++) {
            if (rowIdx == row) {
                continue;
            }
            if (board[rowIdx][col] == target) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicateInCol(char[][] board, int row, int col) {
        char target = board[row][col];
        for (int colIdx = 0; colIdx < board[row].length; colIdx++) {
            if (colIdx == col) {
                continue;
            }
            if (board[row][colIdx] == target) {
                return true;
            }
        }
        return false;
    }

    private boolean isDuplicateInBox(char[][] board, int row, int col) {
        char target = board[row][col];
        for (int rowIdx = 0; rowIdx < 3; rowIdx++) {
            for (int colIdx = 0; colIdx < 3; colIdx++) {
                int actualRow = rowIdx + (3 * (row / 3));
                int actualCol = colIdx + (3 * (col / 3));

                if (actualRow == row && actualCol == col) {
                    continue;
                }
                if (board[actualRow][actualCol] == target) {
                    return true;
                }
            }
        }
        return false;
    }
}