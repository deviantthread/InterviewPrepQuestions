package com.john.leetcode;

import java.util.Map.Entry;

public class Question14 {
    public static void main(String[] args) {

        String[] strs = { "joh does", "joh is", "joh is the", "joh is" };
        String longestCommonPrefix = new Question14().longestCommonPrefix(strs);
        System.out.println("'" + longestCommonPrefix + "'");
    }

    public String longestCommonPrefix(String[] strs) {
        TrieNode trie = TrieNode.createTrie(strs);
        String longest = "";

        while (trie != null) {
            if (trie.getChildren().size() != 1 || trie.isEnd()) {
                break;
            } else {
                Entry<Character, TrieNode> child = trie.getChildren().entrySet().iterator().next();
                longest += child.getKey();
                trie = child.getValue();
            }
        }

        return longest;
    }
}
