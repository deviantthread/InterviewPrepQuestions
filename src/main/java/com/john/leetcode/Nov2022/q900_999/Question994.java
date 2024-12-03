package com.john.leetcode.Nov2022.q900_999;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Question994 {
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return -1;
        }

        int freshOranges = 0;
        Queue<Pair> rottenOranges = new LinkedList<>();

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) {
                    freshOranges++;
                } else if (grid[row][col] == 2) {
                    rottenOranges.offer(new Pair(row, col));
                }
            }
        }

        // no fresh oranges to begin with
        if (freshOranges == 0) {
            return 0;
        }

        int minutes = -1;

        while (!rottenOranges.isEmpty()) {

            Set<Pair> freshNeighbors = new HashSet<>();

            while (!rottenOranges.isEmpty()) {
                Pair rottenOrange = rottenOranges.poll();

                addIfFresh(freshNeighbors, grid, rottenOrange.row + 1, rottenOrange.col);
                addIfFresh(freshNeighbors, grid, rottenOrange.row - 1, rottenOrange.col);
                addIfFresh(freshNeighbors, grid, rottenOrange.row, rottenOrange.col + 1);
                addIfFresh(freshNeighbors, grid, rottenOrange.row, rottenOrange.col - 1);
            }
            minutes++;

            freshOranges -= freshNeighbors.size();

            // rotten them all
            freshNeighbors.forEach(p -> {
                grid[p.row][p.col] = 2;
                rottenOranges.offer(p);
            });
        }

        // couldn't get em all
        if (freshOranges > 0) {
            return -1;
        }

        return minutes;
    }

    private void addIfFresh(Set<Pair> freshNeighbors, int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[row].length || grid[row][col] != 1) {
            return;
        }

        freshNeighbors.add(new Pair(row, col));
    }

    private static class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int hashCode() {
            return String.format("%d%d", row, col).hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Pair other = (Pair) obj;

            return this.row == other.row && this.col == other.col;
        }

        @Override
        public String toString() {
            return String.format("%d,%d", row, col);
        }
    }
}
