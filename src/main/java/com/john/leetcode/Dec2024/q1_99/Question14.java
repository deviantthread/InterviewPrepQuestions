package com.john.leetcode.Dec2024.q1_99;

import java.util.HashMap;
import java.util.Map;

public class Question14 {
    public String longestCommonPrefix(String[] strs) {
        Trie root = new Trie('$');
        for (String str : strs) {
            insertIntoTrie(root, str, 0);
        }

        return findLongestCommonPrefixInTrie(root, "");
    }

    private String findLongestCommonPrefixInTrie(Trie root, String prefix) {
        if (root.children.size() != 1) {
            return prefix;
        }

        Map.Entry<Character, Trie> next = root.children.entrySet().iterator().next();
        if (next.getValue() == wordMarker) {
            return prefix;
        }

        return findLongestCommonPrefixInTrie(next.getValue(), prefix + next.getKey());
    }

    private void insertIntoTrie(Trie root, String str, int strIdx) {
        if (strIdx == str.length()) {
            root.children.put('#', wordMarker);
            return;
        }

        char nextChar = str.charAt(strIdx);
        if (!root.children.containsKey(nextChar)) {
            root.children.put(nextChar, new Trie(nextChar));
        }

        insertIntoTrie(root.children.get(nextChar), str, strIdx + 1);
    }

    private static Trie wordMarker = new Trie('#');

    private static class Trie {
        public Character val;
        public Map<Character, Trie> children = new HashMap<>();

        public Trie(Character val) {
            this.val = val;
        }
    }
}
