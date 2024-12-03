package com.john.leetcode.template.q200_299;

import java.util.HashMap;
import java.util.Map;

public class Question208 {
    public static class Trie {
        Map<Character, Trie> letterMap = new HashMap<>();
        private static final Character END = '#';

        public Trie() {

        }

        public void insert(String word) {
            if ("".equals(word)) {
                letterMap.put(END, null);
            } else {
                Trie trie = letterMap.computeIfAbsent(word.charAt(0), k -> new Trie());
                trie.insert(word.substring(1));
            }
        }

        public boolean search(String word) {
            if ("".equals(word)) {
                return letterMap.containsKey(END);
            } else if (!letterMap.containsKey(word.charAt(0))) {
                return false;
            } else {
                return letterMap.get(word.charAt(0)).search(word.substring(1));
            }
        }

        public boolean startsWith(String prefix) {
            if ("".equals(prefix)) {
                return true;
            } else if (!letterMap.containsKey(prefix.charAt(0))) {
                return false;
            } else {
                return letterMap.get(prefix.charAt(0)).startsWith(prefix.substring(1));
            }
        }
    }
}
