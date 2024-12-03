package com.john.leetcode;

public class Question74 {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 3, 5, 7 },
                { 10, 11, 16, 20 },
                { 23, 30, 34, 50 }
        };
        int target = 35;
        System.out.println(new Question74().searchMatrix(matrix, target));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowIdx = findRow(matrix, target, 0, matrix.length - 1);

        if (rowIdx == -1) {
            return false;
        }

        return findTarget(matrix[rowIdx], target, 0, matrix[rowIdx].length - 1);
    }

    private int findRow(int[][] matrix, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;

        if (matrix[mid][0] <= target) {
            // found the right row
            if (mid == matrix.length - 1 || matrix[mid + 1][0] > target) {
                return mid;
            } else {
                return findRow(matrix, target, mid + 1, end);
            }
        } else {
            return findRow(matrix, target, start, mid - 1);
        }

    }

    private boolean findTarget(int[] row, int target, int start, int end) {
        if (start > end) {
            return false;
        }

        int mid = (start + end) / 2;
        if (row[mid] == target) {
            return true;
        } else if (row[mid] < target) {
            return findTarget(row, target, mid + 1, end);
        } else {
            return findTarget(row, target, start, mid - 1);
        }
    }
}
