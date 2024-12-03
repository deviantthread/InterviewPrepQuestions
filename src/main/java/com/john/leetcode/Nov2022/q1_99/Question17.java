package com.john.leetcode.Nov2022.q1_99;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question17 {
    static Map<Character, String[]> digitsToLetters = new HashMap<>();

    static {
        digitsToLetters.put('2', new String[] { "a", "b", "c" });
        digitsToLetters.put('3', new String[] { "d", "e", "f" });
        digitsToLetters.put('4', new String[] { "g", "h", "i" });
        digitsToLetters.put('5', new String[] { "j", "k", "l" });
        digitsToLetters.put('6', new String[] { "m", "n", "o" });
        digitsToLetters.put('7', new String[] { "p", "q", "r", "s" });
        digitsToLetters.put('8', new String[] { "t", "u", "v" });
        digitsToLetters.put('9', new String[] { "w", "x", "y", "z" });
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        List<String> ret = new ArrayList<>();

        letterCombinations(digits, ret, 0, "");

        return ret;
    }

    private void letterCombinations(String digits, List<String> ret, int idx, String str) {
        if (idx == digits.length()) {
            ret.add(str);
            return;
        }

        for (String letter : digitsToLetters.get(digits.charAt(idx))) {
            letterCombinations(digits, ret, idx + 1, str + letter);
        }
    }
}
