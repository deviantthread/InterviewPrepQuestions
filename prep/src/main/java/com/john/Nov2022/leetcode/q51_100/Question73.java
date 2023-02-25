package com.john.Nov2022.leetcode.q51_100;

import java.util.HashSet;
import java.util.Set;

public class Question73 {
    public void setZeroes(int[][] matrix) {
        Set<Integer> zeroRows = new HashSet<>(matrix.length);
        Set<Integer> zeroCols = new HashSet<>(matrix[0].length);

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    zeroRows.add(row);
                    zeroCols.add(col);
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (zeroRows.contains(row) || zeroCols.contains(col)) {
                    matrix[row][col] = 0;
                }
            }
        }
    }
}
