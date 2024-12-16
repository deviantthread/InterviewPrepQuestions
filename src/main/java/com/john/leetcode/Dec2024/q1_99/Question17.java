package com.john.leetcode.Dec2024.q1_99;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Question17 {

    private static final Map<Character, char[]> numberToCharacters = new HashMap<>();

    static {
        numberToCharacters.put('2', new char[] { 'a', 'b', 'c' });
        numberToCharacters.put('3', new char[] { 'd', 'e', 'f' });
        numberToCharacters.put('4', new char[] { 'g', 'h', 'i' });
        numberToCharacters.put('5', new char[] { 'j', 'k', 'l' });
        numberToCharacters.put('6', new char[] { 'm', 'n', 'o' });
        numberToCharacters.put('7', new char[] { 'p', 'q', 'r', 's' });
        numberToCharacters.put('8', new char[] { 't', 'u', 'v' });
        numberToCharacters.put('9', new char[] { 'w', 'x', 'y', 'z' });
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        letterCombos(digits, 0, "", result);

        return result;
    }

    private void letterCombos(String digits, int digitIdx, String combo, List<String> result) {
        if (digitIdx == digits.length()) {
            result.add(combo);
            return;
        }

        char[] digitLetters = numberToCharacters.get(digits.charAt(digitIdx));
        for (char letter : digitLetters) {
            letterCombos(digits, digitIdx + 1, combo + letter, result);
        }
    }
}