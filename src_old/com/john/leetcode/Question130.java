package com.john.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class Question130 {

	public static void main(String[] args) {

		char[][] board = {
				{ 'X', 'X', 'X', 'X' },
				{ 'X', 'O', 'O', 'X' },
				{ 'X', 'X', 'O', 'O' },
				{ 'X', 'O', 'O', 'X' },
				{ 'X', 'X', 'X', 'X' },
		};

		printBoard(board);
		new Question130().solve(board);
		printBoard(board);
	}

	private static void printBoard(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();

	}

	public void solve(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'O') {

					if (isRegionSurrounded(board, i, j)) {
						// flip em to X's
						flipRegion(board, i, j, 'X');
					} else {
						// prevent duplicate recursing for the same group
						flipRegion(board, i, j, 'Y');
					}
				}
			}
		}

		// put it back
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 'Y') {
					board[i][j] = 'O';
				}
			}
		}

	}

	private void flipRegion(char[][] board, int i, int j, char c) {
		Queue<Pos> q = new LinkedList<Pos>();
		boolean[][] visited = new boolean[board.length][board[i].length];
		q.add(new Pos(i, j));

		while (!q.isEmpty()) {
			Pos pos = q.remove();
			if (pos.x == board.length || pos.x < 0 || pos.y == board[i].length
					|| pos.y < 0) {
				continue;
			}
			if (visited[pos.x][pos.y]) {
				continue;
			}

			visited[pos.x][pos.y] = true;

			if (board[pos.x][pos.y] == 'O') {
				board[pos.x][pos.y] = c;
				q.add(new Pos(pos.x + 1, pos.y));
				q.add(new Pos(pos.x - 1, pos.y));
				q.add(new Pos(pos.x, pos.y + 1));
				q.add(new Pos(pos.x, pos.y - 1));
			}
		}
	}

	private boolean isRegionSurrounded(char[][] board, int i, int j) {
		Queue<Pos> q = new LinkedList<Pos>();
		boolean[][] visited = new boolean[board.length][board[i].length];
		q.add(new Pos(i, j));

		while (!q.isEmpty()) {
			Pos pos = q.remove();
			if (pos.x == board.length || pos.x < 0 || pos.y == board[i].length
					|| pos.y < 0) {
				return false;
			}
			if (visited[pos.x][pos.y]) {
				continue;
			}

			visited[pos.x][pos.y] = true;

			if (board[pos.x][pos.y] == 'O') {
				q.add(new Pos(pos.x + 1, pos.y));
				q.add(new Pos(pos.x - 1, pos.y));
				q.add(new Pos(pos.x, pos.y + 1));
				q.add(new Pos(pos.x, pos.y - 1));
			}
		}
		return true;
	}

	public static class Pos {
		public int x;
		public int y;

		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Pos (" + x + "," + y + ")";
		}

	}
}
