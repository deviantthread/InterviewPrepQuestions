package com.john.leetcode;

public class Question200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numIslands(char[][] grid) {
		if (grid == null) {
			return 0;
		}
		int count = 0;
		for (int row = 0; row < grid.length; row++) {
			for (int col = 0; col < grid[row].length; col++) {
				if (grid[row][col] == '1') {
					dfs(grid, row, col);
					count++;
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int row, int col) {
		if (row < 0 || row == grid.length || col < 0 || col == grid[row].length) {
			return;
		}

		if (grid[row][col] == '1') {
			grid[row][col] = '2';
			dfs(grid, row + 1, col);
			dfs(grid, row - 1, col);
			dfs(grid, row, col + 1);
			dfs(grid, row, col - 1);
		}
	}

}
