package com.john.leetcode.Dec2024.q1_99;

import java.util.ArrayList;
import java.util.List;

public class Question22 {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char[] combo = new char[n * 2];
        generateParens(n, 0, 0, combo, 0, result);

        return result;
    }

    private void generateParens(int n, int numOpenParens, int numClosedParens, char[] combo, int comboIdx, List<String> result) {
        if (numOpenParens == n && numClosedParens == n) {
            result.add(new String(combo));
            return;
        }

        if (numOpenParens < n) {
            combo[comboIdx] = '(';
            generateParens(n, numOpenParens + 1, numClosedParens, combo, comboIdx + 1, result);
        }
        if (numOpenParens > numClosedParens) {
            combo[comboIdx] = ')';
            generateParens(n, numOpenParens, numClosedParens + 1, combo, comboIdx + 1, result);
        }
    }
}