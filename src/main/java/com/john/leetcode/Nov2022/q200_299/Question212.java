package com.john.leetcode.Nov2022.q200_299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Question212 {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new ArrayList<>();

        for (String word : words) {
            if (foundWord(word, board)) {
                ret.add(word);
            }
        }

        return ret;
    }

    private boolean foundWord(String word, char[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                boolean[][] visited = new boolean[board.length][board[0].length];

                if (dfsFoundWord(word, 0, board, row, col, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfsFoundWord(String word, int wordIdx, char[][] board, int row, int col, boolean[][] visited) {
        if (wordIdx >= word.length()) {
            return true;
        } else if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return false;
        } else if (visited[row][col] || board[row][col] != word.charAt(wordIdx)) {
            return false;
        }

        visited[row][col] = true;
        boolean found = dfsFoundWord(word, wordIdx + 1, board, row + 1, col, visited) ||
            dfsFoundWord(word, wordIdx + 1, board, row - 1, col, visited) ||
            dfsFoundWord(word, wordIdx + 1, board, row, col + 1, visited) ||
            dfsFoundWord(word, wordIdx + 1, board, row, col - 1, visited);

        visited[row][col] = false;
        return found;
    }
    public List<String> findWordsSlowTrie(char[][] board, String[] words) {
        Trie trie = buildTrie(board);

        return Arrays.stream(words)
            .filter(trie::contains)
            .collect(Collectors.toList());
    }

    private Trie buildTrie(char[][] board) {
        Trie trie = new Trie();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                boolean[][] visited = new boolean[board.length][board[0].length];
                populateTrie(trie, board, "", row, col, visited);
            }
        }

        return trie;
    }

    private void populateTrie(Trie trie, char[][] board, String curr, int row, int col, boolean[][] visited) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            trie.addWord(curr);
            return;
        } else if (visited[row][col]) {
            return;
        }

        curr += board[row][col];
        visited[row][col] = true;
        populateTrie(trie, board, curr, row + 1, col, visited);
        populateTrie(trie, board, curr, row - 1, col, visited);
        populateTrie(trie, board, curr, row, col + 1, visited);
        populateTrie(trie, board, curr, row, col - 1, visited);
        visited[row][col] = false;
    }

    private static class Trie {
        Map<Character, Trie> letterMap = new HashMap<>();

        public void addWord(String word) {
            if (!"".equals(word)) {
                letterMap.computeIfAbsent(word.charAt(0), k -> new Trie());
                letterMap.get(word.charAt(0)).addWord(word.substring(1));
            }
        }

        public boolean contains(String word) {
            if ("".equals(word)) {
                return true;
            } else if (letterMap.containsKey(word.charAt(0))) {
                return letterMap.get(word.charAt(0)).contains(word.substring(1));
            } else {
                return false;
            }
        }
    }

}
