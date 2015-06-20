package com.john.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Question212 {

    public static void main(String[] args) {
        // char[][] board = {
        // { 'o', 'a', 'a', 'n' },
        // { 'e', 't', 'a', 'e' },
        // { 'i', 'h', 'k', 'r' },
        // { 'i', 'f', 'l', 'v' }
        // };

        char[][] board = {
                { 'a', 'b' },
                { 'c', 'd' },
        };

        // String[] words = { "oath", "pea", "eat", "eakht", "", "rain" };
        String[] words = { "ab", "cb", "ad", "bd", "ac", "ca", "da", "bc", "db", "adcb", "dabc", "abb", "acb" };
        List<String> foundWords = new Question212().findWords(board, words);

        for (String word : foundWords) {
            System.out.println(word);
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Node root = createTrie(words);
        Set<String> foundWords = new HashSet<String>();

        boolean[][] visited = new boolean[board.length][];
        for (int row = 0; row < board.length; row++) {
            visited[row] = new boolean[board[row].length];
        }

        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (root.children.containsKey(board[row][col])) {

                    dfs(board, row, col, visited, root, foundWords, sb);
                }
            }
        }

        return new ArrayList<String>(foundWords);
    }

    private void dfs(char[][] board, int row, int col, boolean[][] visited,
            Node node, Set<String> foundWords, StringBuilder wordSoFar)
    {
        if (row < 0 || row == board.length || col < 0 || col == board[row].length) {
            return;
        } else if (visited[row][col]) {
            return;
        }

        // i'm not making progress on my word, quit
        if (!node.children.containsKey(board[row][col])) {
            return;
        }

        visited[row][col] = true;
        wordSoFar.append(board[row][col]);

        Node child = node.children.get(board[row][col]);
        if (child.isEnd) {
            foundWords.add(wordSoFar.toString());
        }

        dfs(board, row, col - 1, visited, child, foundWords, wordSoFar);
        dfs(board, row + 1, col, visited, child, foundWords, wordSoFar);
        dfs(board, row, col + 1, visited, child, foundWords, wordSoFar);
        dfs(board, row - 1, col, visited, child, foundWords, wordSoFar);

        visited[row][col] = false;
        wordSoFar.deleteCharAt(wordSoFar.length() - 1);

        return;
    }

    private Node createTrie(String[] words) {
        Node root = new Node();
        for (String word : words) {
            addWordToTrie(root, word.toCharArray(), 0);
        }

        return root;
    }

    private void addWordToTrie(Node node, char[] charArray, int i) {
        if (i >= charArray.length) {
            node.isEnd = true;
            return;
        }

        Node child;
        if (!node.children.containsKey(charArray[i])) {
            child = new Node();
            node.children.put(charArray[i], child);
        } else {
            child = node.children.get(charArray[i]);
        }

        addWordToTrie(child, charArray, i + 1);
    }

    private class Node {
        public Map<Character, Node> children = new HashMap<Character, Node>();
        public boolean isEnd = false;
    }
}
