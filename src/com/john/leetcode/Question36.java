package com.john.leetcode;

public class Question36 {

    public static void main(String[] args) {

        char[][] board = {
                "..4...63.".toCharArray(),
                ".........".toCharArray(),
                "5......9.".toCharArray(),
                "...56....".toCharArray(),
                "4.3.....1".toCharArray(),
                "...7.....".toCharArray(),
                "...5.....".toCharArray(),
                ".........".toCharArray(),
                ".........".toCharArray()
        };
        // char[][] board = {
        // "53..7....".toCharArray(),
        // "6..195...".toCharArray(),
        // ".98....6.".toCharArray(),
        // "8...6...3".toCharArray(),
        // "4..8.3..1".toCharArray(),
        // "7...2...6".toCharArray(),
        // ".6....28.".toCharArray(),
        // "...419..5".toCharArray(),
        // "....8..79".toCharArray()
        // };
        System.out.println(new Question36().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        return solveAt(board, 0, 0);
    }

    private boolean solveAt(char[][] board, int row, int col) {
        // skip squares with numbers already, and handle looping
        while (col == board[row].length || board[row][col] != '.') {
            if (col == board[row].length) {
                col = 0;
                row++;
            }

            // reached the end of the board, and everything is filled in, success!
            if (row == board.length) {
                return true;
            }
            col++;
        }

        for (int num = 1; num <= 9; num++) {
            char digit = Character.forDigit(num, 10);
            if (isValid(board, row, col, digit)) {
                board[row][col] = digit;

                if (!solveAt(board, row, col + 1)) {
                    board[row][col] = '.';
                } else {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(char[][] board, int row, int col, char num) {
        return isValidInRow(board, row, num)
                && isValidInCol(board, col, num)
                && isValidInBox(board, row, col, num);
    }

    private boolean isValidInBox(char[][] board, int row, int col, char num) {
        int boxX = col / 3;
        int boxY = row / 3;
        boxX *= 3;
        boxY *= 3;
        for (int i = boxY; i < boxY + 3; i++) {
            for (int j = boxX; j < boxX + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidInCol(char[][] board, int col, char num) {
        for (int row = 0; row < board.length; row++) {
            if (board[row][col] == num) {
                return false;
            }
        }
        return true;
    }

    private boolean isValidInRow(char[][] board, int row, char num) {
        for (int col = 0; col < board[0].length; col++) {
            if (board[row][col] == num) {
                return false;
            }
        }
        return true;
    }
}
