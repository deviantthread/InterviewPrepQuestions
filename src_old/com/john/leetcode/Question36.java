package com.john.leetcode;

public class Question36 {

    public static void main(String[] args) {

        // char[][] board = {
        // "..4...63.".toCharArray(),
        // ".........".toCharArray(),
        // "5......9.".toCharArray(),
        // "...56....".toCharArray(),
        // "4.3.....1".toCharArray(),
        // "...7.....".toCharArray(),
        // "...5.....".toCharArray(),
        // ".........".toCharArray(),
        // ".........".toCharArray()
        // };
        char[][] board = {
                "53..7....".toCharArray(),
                "6..195...".toCharArray(),
                ".98....6.".toCharArray(),
                "8...6...3".toCharArray(),
                "4..8.3..1".toCharArray(),
                "7...2...6".toCharArray(),
                ".6....28.".toCharArray(),
                "...419..5".toCharArray(),
                "....8..79".toCharArray()
        };
        System.out.println(new Question36().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (board[row][col] == '.') {
                    continue;
                }

                if (!isValid(board, row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(char[][] board, int row, int col) {
        return isValidInRow(board, row, col)
                && isValidInCol(board, row, col)
                && isValidInBox(board, row, col);
    }

    private boolean isValidInBox(char[][] board, int row, int col) {
        int boxX = col / 3;
        int boxY = row / 3;
        boxX *= 3;
        boxY *= 3;
        char num = board[row][col];
        for (int i = boxY; i < boxY + 3; i++) {
            for (int j = boxX; j < boxX + 3; j++) {
                if (i == row && j == col) {
                    continue;
                }
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidInCol(char[][] board, int row, int col) {
        char num = board[row][col];
        for (int i = 0; i < board.length; i++) {
            if (i == row) {
                continue;
            }
            if (board[i][col] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidInRow(char[][] board, int row, int col) {
        char num = board[row][col];
        for (int i = 0; i < board[0].length; i++) {
            if (i == col) {
                continue;
            }
            if (board[row][i] == num) {
                return false;
            }
        }
        return true;
    }
}
