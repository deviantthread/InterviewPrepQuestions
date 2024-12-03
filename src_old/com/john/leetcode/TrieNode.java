package com.john.leetcode;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    private final Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
    private boolean isEnd = false;

    public Map<Character, TrieNode> getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public static TrieNode createTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            addWordToTrie(root, word.toCharArray(), 0);
        }

        return root;
    }

    public static void addWordToTrie(TrieNode node, char[] charArray, int i) {
        if (i >= charArray.length) {
            node.isEnd = true;
            return;
        }

        TrieNode child;
        if (!node.children.containsKey(charArray[i])) {
            child = new TrieNode();
            node.children.put(charArray[i], child);
        } else {
            child = node.children.get(charArray[i]);
        }

        addWordToTrie(child, charArray, i + 1);
    }

}
