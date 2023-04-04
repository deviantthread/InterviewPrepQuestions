package com.john.Nov2022.leetcode.q600_699;

public class Question695 {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1 && !visited[row][col]) {
                    maxArea = Math.max(maxArea, dfsFindArea(grid, row, col, visited));
                }
            }
        }

        return maxArea;
    }

    private int dfsFindArea(int[][] grid, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || visited[row][col] || grid[row][col] != 1) {
            return 0;
        }

        visited[row][col] = true;

        return 1 + dfsFindArea(grid, row + 1, col, visited)
            + dfsFindArea(grid, row - 1, col, visited)
            + dfsFindArea(grid, row, col + 1, visited)
            + dfsFindArea(grid, row, col - 1, visited);
    }
}
