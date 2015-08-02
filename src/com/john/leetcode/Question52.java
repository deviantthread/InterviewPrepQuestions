package com.john.leetcode;

public class Question52 {

	public static void main(String[] args) {

		int num = new Question52().totalNQueens(4);
		System.out.println(num);
	}

	public int totalNQueens(int n) {
		if (n < 1) {
			return 0;
		}

		char[][] board = new char[n][n];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = '.';
			}
		}

		return solveNQueens(0, board);
	}

	private int solveNQueens(int col, char[][] board) {
		if (col == board.length) {
			return 1;
		}
		int ret = 0;
		for (int row = 0; row < board.length; row++) {
			if (rowIsEmpty(board, row) && diagonalsAreEmpty(board, row, col)) {
				board[row][col] = 'Q';
				ret += solveNQueens(col + 1, board);
				board[row][col] = '.';
			}
		}
		return ret;
	}

	private boolean diagonalsAreEmpty(char[][] board, int row, int col) {
		int upRow = row + 1;
		int downRow = row - 1;
		int c = col - 1;

		while (c >= 0) {
			if (upRow < board.length) {
				if (board[upRow++][c] == 'Q') {
					return false;
				}
			}
			if (downRow >= 0) {
				if (board[downRow--][c] == 'Q') {
					return false;
				}
			}
			c--;
		}

		return true;
	}

	private boolean rowIsEmpty(char[][] board, int row) {
		for (int i = 0; i < board.length; i++) {
			if (board[row][i] == 'Q') {
				return false;
			}
		}
		return true;
	}

}
