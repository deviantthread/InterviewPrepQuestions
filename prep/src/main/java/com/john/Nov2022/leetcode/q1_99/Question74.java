package com.john.Nov2022.leetcode.q1_99;

public class Question74 {
    public boolean searchMatrix(int[][] matrix, int target) {

        int rowIdx = findRowIndex(matrix, target);
        if (rowIdx == -1) {
            return false;
        }

        int colIdx = findIndex(matrix[rowIdx], target, 0, matrix[rowIdx].length - 1);
        return colIdx >= 0;
    }

    private int findRowIndex(int[][] matrix, int target) {
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[matrix.length - 1].length - 1]) {
            return -1;
        }
        //ok we know it should be somewhere in the middle

        return findRowIndex(matrix, target, 0, matrix.length - 1);
    }

    private int findRowIndex(int[][] matrix, int target, int top, int bottom) {
        if (bottom - top <= 1) {
            boolean isBottomTooHigh = matrix[bottom][0] > target;
            return isBottomTooHigh ? top : bottom;
        }

        int mid = top + (bottom - top) / 2;
        if (matrix[mid][0] == target) {
            return mid;
        } else if (matrix[mid][0] > target) {
            return findRowIndex(matrix, target, top, mid - 1);
        } else {
            return findRowIndex(matrix, target, mid, bottom);
        }
    }

    private int findIndex(int[] matrix, int target, int left, int right) {
        if (right - left <= 1) {
            if (matrix[right] == target) {
                return right;
            } else if (matrix[left] == target) {
                return left;
            } else {
                return -1;
            }
        }

        int mid = left + (right - left) / 2;

        if (matrix[mid] == target) {
            return mid;
        } else if (matrix[mid] < target) {
            return findIndex(matrix, target, mid + 1, right);
        } else {
            return findIndex(matrix, target, left, mid - 1);
        }
    }
}
