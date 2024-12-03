package com.john.leetcode.Nov2022.q1000_1099;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Question1091 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        PriorityQueue<Path> queue = new PriorityQueue<>(Comparator.comparing(p -> p.pathLen));
        queue.offer(new Path(0, 0, 1));
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        while (!queue.isEmpty()) {
            Path shortestPath = queue.poll();

            int row = shortestPath.row;
            int col = shortestPath.col;

            if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != 0 || visited[row][col]) {
                continue;
            }

            // reached the end!
            if (row == grid.length - 1 && col == grid[row].length - 1) {
                return shortestPath.pathLen;
            }

            visited[row][col] = true;

            int newPathLen = shortestPath.pathLen + 1;

            for (int newRow = -1; newRow <= 1; newRow++) {
                for (int newCol = -1; newCol <= 1; newCol++) {
                    if (newRow == 0 && newCol == 0) {
                        continue;
                    }

                    queue.offer(new Path(row + newRow, col + newCol, newPathLen));
                }
            }
        }

        return -1;
    }

    private static class Path {
        int row;
        int col;
        int pathLen;

        public Path(int row, int col, int pathLen) {
            this.row = row;
            this.col = col;
            this.pathLen = pathLen;
        }
    }
}
