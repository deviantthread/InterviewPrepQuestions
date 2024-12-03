package com.john.leetcode.Nov2022.q1_99;

public class Question79 {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][];
        for (int i = 0; i < board.length; i++) {
            visited[i] = new boolean[board[i].length];
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (dfsExist(board, word, row, col, 0, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfsExist(char[][] board, String word, int row, int col, int letterIdx, boolean[][] visited) {
        if (letterIdx >= word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return false;
        }
        if (board[row][col] != word.charAt(letterIdx)) {
            return false;
        }
        if (visited[row][col]) {
            return false;
        }

        visited[row][col] = true;

        boolean result = dfsExist(board, word, row + 1, col, letterIdx + 1, visited) ||
            dfsExist(board, word, row - 1, col, letterIdx + 1, visited) ||
            dfsExist(board, word, row, col + 1, letterIdx + 1, visited) ||
            dfsExist(board, word, row, col - 1, letterIdx + 1, visited);

        visited[row][col] = false;
        return result;
    }
}
