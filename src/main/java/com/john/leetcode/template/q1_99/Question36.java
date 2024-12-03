package com.john.leetcode.template.q1_99;

public class Question36 {
    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (!Character.isDigit(board[row][col])) {
                    continue;
                }

                if (isDuplicateInRow(board, row, col) ||
                    isDuplicateInCol(board, row, col) ||
                    isDuplicateInBox(board, row, col)) {
                    return false;
                }
            }
        }
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
