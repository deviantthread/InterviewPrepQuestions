package com.john.leetcode;

public class Question240 {

    public static void main(String[] args) {
        // int[][] matrix = {
        // { 1, 4, 7, 11, 15 },
        // { 2, 5, 8, 12, 19 },
        // { 3, 6, 9, 16, 22 },
        // { 10, 13, 14, 17, 24 },
        // { 18, 21, 23, 26, 30 }
        // };

        int[][] matrix = { { -1, 3 } };
        int target = 3;
        System.out.println(new Question240().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        // binary search the top left to bottom right diagonal. once "i" < target and "i-1" is lesser then you know that
        // the number must be on the row "i" (to 0..col i) or the col "i"(rows 0..row i). we can binary search both of
        // those
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        Pos diagonal = findDiagonal(matrix, target, new Pos(0, 0), new Pos(m, n));
        if (diagonal == null) {
            return false;
        }

        return searchRow(matrix, target, diagonal.row, 0, diagonal.col)
                || searchCol(matrix, target, 0, diagonal.row, diagonal.col);
    }

    private Pos findDiagonal(int[][] matrix, int target, Pos start, Pos end) {
        if (start.row > end.row) {
            return null;
        }

        int midRow = (start.row + end.row) / 2;
        int midCol = (start.col + end.col) / 2;
        Pos mid = new Pos(midRow, midCol);

        int num = matrix[mid.row][mid.col];
        Pos lessDiag = new Pos(mid.row - 1, mid.col - 1);
        if (num >= target) {
            boolean isFirstRow = mid.row == 0;
            boolean isFirstCol = mid.col == 0;
            if (isFirstRow || isFirstCol || matrix[lessDiag.row][lessDiag.col] < target) {
                // find the right diagonal
                return mid;
            } else {
                return findDiagonal(matrix, target, start, lessDiag);
            }
        } else {
            Pos moreDiag = new Pos(mid.row + 1, mid.col + 1);
            return findDiagonal(matrix, target, moreDiag, end);
        }
    }

    private boolean searchRow(int[][] matrix, int target, int row, int colStart, int colEnd) {
        if (colStart > colEnd) {
            return false;
        }
        int mid = (colStart + colEnd) / 2;

        int num = matrix[row][mid];
        if (num == target) {
            return true;
        } else if (num < target) {
            return searchRow(matrix, target, row, mid + 1, colEnd);
        } else {
            return searchRow(matrix, target, row, colStart, mid - 1);
        }
    }

    private boolean searchCol(int[][] matrix, int target, int rowStart, int rowEnd, int col) {
        if (rowStart > rowEnd) {
            return false;
        }
        int mid = (rowStart + rowEnd) / 2;

        int num = matrix[mid][col];
        if (num == target) {
            return true;
        } else if (num < target) {
            return searchCol(matrix, target, mid + 1, rowEnd, col);
        } else {
            return searchCol(matrix, target, rowStart, mid - 1, col);
        }
    }

    private static class Pos {
        int row = -1;
        int col = -1;

        Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return row + "," + col;
        }
    }

}
