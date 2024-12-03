package com.john.leetcode.Nov2022.q200_299;

import java.util.HashMap;
import java.util.Map;

public class Question211 {
    public static class WordDictionary {
        private final Map<Character, WordDictionary> letterMap = new HashMap<>();
        private static final Character END = '#';

        public WordDictionary() {

        }

        public void addWord(String word) {
            if ("".equals(word)) {
                letterMap.put(END, null);
            } else {
                letterMap.computeIfAbsent(word.charAt(0), k -> new WordDictionary());
                letterMap.get(word.charAt(0)).addWord(word.substring(1));
            }
        }

        public boolean search(String word) {
            if ("".equals(word)) {
                return letterMap.containsKey(END);
            } else if ('.' == word.charAt(0)) {
                //need to check all available chars
                for (Character character : letterMap.keySet()) {
                    if (character == END) {
                        continue;
                    }

                    if (letterMap.get(character).search(word.substring(1))) {
                        return true;
                    }
                }
                return false;
            } else if (letterMap.containsKey(word.charAt(0))) {
                return letterMap.get(word.charAt(0)).search(word.substring(1));
            } else {
                return false;
            }
        }
    }
}
