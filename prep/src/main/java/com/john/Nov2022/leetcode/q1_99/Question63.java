package com.john.Nov2022.leetcode.q1_99;

public class Question63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] mem = new int[obstacleGrid.length][obstacleGrid[0].length];

        return uniquePathsWithObstaclesWithMem(0, 0, mem, obstacleGrid);
    }

    private int uniquePathsWithObstaclesWithMem(int row, int col, int[][] mem, int[][] obstacleGrid) {
        if (row >= obstacleGrid.length || col >= obstacleGrid[row].length || obstacleGrid[row][col] == 1) {
            return 0;
        } else if (mem[row][col] > 0) {
            return mem[row][col];
            // we ran off the edge or hit an obstacle
            //made it <horns go off>, <fireworks shoot>, <wears party hat>
        } else if (row == obstacleGrid.length - 1 && col == obstacleGrid[row].length - 1) {
            return 1;
        }

        int paths = uniquePathsWithObstaclesWithMem(row + 1, col, mem, obstacleGrid) +
            uniquePathsWithObstaclesWithMem(row, col + 1, mem, obstacleGrid);

        mem[row][col] = paths;

        return paths;
    }
}
