package com.john.leetcode.Dec2024.q1_99;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question30 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        boolean[] chosen = new boolean[words.length];
        List<String> permutations = new ArrayList<>();
        generatePermutations(words, chosen, 0, "", permutations);

        Trie trie = buildTrie(permutations);
        int depth = findDepth(trie, 0);

        for (int i = 0; i < s.length(); i++) {
            if (isInTrie(s.substring(i), 0, depth, trie)) {
                result.add(i);
            }
        }

        return result;
    }

    private int findDepth(Trie trie, int depth) {
        if (trie.children.containsKey(wordMarker.val)) {
            return depth;
        }
        return findDepth(trie.children.values().iterator().next(), depth + 1);
    }

    private boolean isInTrie(String s, int idx, int depth, Trie trie) {
        if (idx == depth) {
            return trie.children.containsKey(wordMarker.val);
        } else if (idx >= s.length()) {
            return false;
        }

        char letter = s.charAt(idx);
        if (!trie.children.containsKey(letter)) {
            return false;
        }

        return isInTrie(s, idx + 1, depth, trie.children.get(letter));
    }

    private Trie buildTrie(List<String> permutations) {
        Trie root = new Trie('$');
        for (String permutation : permutations) {
            addToTrie(root, permutation, 0);
        }

        return root;
    }

    private void addToTrie(Trie root, String permutation, int idx) {
        if (idx == permutation.length()) {
            root.children.put(wordMarker.val, wordMarker);
            return;
        }

        char letter = permutation.charAt(idx);
        if (!root.children.containsKey(letter)) {
            root.children.put(letter, new Trie(letter));
        }

        addToTrie(root.children.get(letter), permutation, idx + 1);
    }

    private void generatePermutations(String[] words, boolean[] chosen, int depth, String permutation, List<String> permutations) {
        if (depth == words.length) {
            permutations.add(permutation);
            return;
        }

        for (int i = 0; i < words.length; i++) {
            if (!chosen[i]) {
                chosen[i] = true;
                generatePermutations(words, chosen, depth + 1, permutation + words[i], permutations);
                chosen[i] = false;
            }
        }
    }

    private static final Trie wordMarker = new Trie('#');

    private static class Trie {
        char val;
        Map<Character, Trie> children = new HashMap<>();

        public Trie(char val) {
            this.val = val;
        }
    }
}
