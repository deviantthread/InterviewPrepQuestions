package com.john.leetcode.Dec2024.q1200_1299;

import com.john.utils.PrettyPrinter;

public class Question1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] matrix = new int[m][n];

        for (int[] increments : indices) {
            int x = increments[0];
            int y = increments[1];

            for (int i = 0; i < m; i++) {
                matrix[i][y]++;
            }

            for (int i = 0; i < n; i++) {
                matrix[x][i]++;
            }
        }

        int result = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value % 2 == 1) {
                    result++;
                }
            }
        }

        return result;
    }
}
