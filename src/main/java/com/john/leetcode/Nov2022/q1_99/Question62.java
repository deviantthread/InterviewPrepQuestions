package com.john.leetcode.Nov2022.q1_99;

public class Question62 {
    public int uniquePaths(int m, int n) {

        int[][] mem = new int[m][n];

        return uniquePathsWithMem(0, 0, m, n, mem);
    }

    private int uniquePathsWithMem(int row, int col, int m, int n, int[][] mem) {
        if (mem[row][col] > 0) {
            return mem[row][col];
        } else if (row == m - 1 && col == n - 1) {
            mem[row][col] = 1;
            return 1;
        }

        // i can move down
        boolean canMoveDown = row + 1 < m;
        boolean canMoveRight = col + 1 < n;

        int paths = 0;

        if (canMoveDown) {
            paths += uniquePathsWithMem(row + 1, col, m, n, mem);
        }

        if (canMoveRight) {
            paths += uniquePathsWithMem(row, col + 1, m, n, mem);
        }

        mem[row][col] = paths;
        return mem[row][col];
    }
}
