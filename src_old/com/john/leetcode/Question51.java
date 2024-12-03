package com.john.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Question51 {

	public static void main(String[] args) {

		List<List<String>> solveNQueens = new Question51().solveNQueens(0);
		for (List<String> board : solveNQueens) {
			System.out.println("\n");

			for (String s : board) {
				System.out.println(s);
			}
		}
	}

	public List<List<String>> solveNQueens(int n) {
		if (n < 1) {
			return new ArrayList<List<String>>();
		}

		List<List<String>> ret = new ArrayList<List<String>>();
		char[][] board = new char[n][n];
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = '.';
			}
		}

		solveNQueens(ret, 0, board);
		return ret;
	}

	private void solveNQueens(List<List<String>> ret, int col, char[][] board) {
		if (col == board.length) { // need "is board full of queens" check?
			ret.add(convertBoard(board));
			return;
		}

		for (int row = 0; row < board.length; row++) {
			if (rowIsEmpty(board, row) && diagonalsAreEmpty(board, row, col)) {
				board[row][col] = 'Q';
				solveNQueens(ret, col + 1, board);
				board[row][col] = '.';
			}
		}
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

	private List<String> convertBoard(char[][] board) {
		List<String> ret = new ArrayList<String>();
		for (int row = 0; row < board.length; row++) {
			String s = "";
			for (int col = 0; col < board[row].length; col++) {
				s += board[row][col];
			}
			ret.add(s);
		}

		return ret;
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
