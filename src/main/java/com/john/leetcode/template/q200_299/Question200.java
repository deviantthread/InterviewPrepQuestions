package com.john.leetcode.template.q200_299;

public class Question200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1' && !visited[row][col]) {
                    numIslands++;
                    dfsVisitIsland(grid, row, col, visited);
                }
            }
        }

        return numIslands;
    }

    private void dfsVisitIsland(char[][] grid, int row, int col, boolean[][] visited) {
        // we've entered the void D:
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length) {
            return;
        }

        // we've been here before, boooooring
        if (visited[row][col]) {
            return;
        }

        // we swimming
        if (grid[row][col] != '1') {
            return;
        }

        // this place is aight i guess, lets see what else is around
        visited[row][col] = true;

        dfsVisitIsland(grid, row + 1, col, visited);
        dfsVisitIsland(grid, row - 1, col, visited);
        dfsVisitIsland(grid, row, col + 1, visited);
        dfsVisitIsland(grid, row, col - 1, visited);
    }
}
