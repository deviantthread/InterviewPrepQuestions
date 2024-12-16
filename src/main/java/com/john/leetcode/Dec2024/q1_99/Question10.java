package com.john.leetcode.Dec2024.q1_99;

public class Question10 {
    public boolean isMatch(String s, String p) {
        boolean[][] visited = new boolean[s.length() + 1][p.length() + 1];
        return isMatch(visited, s, 0, p, 0);
    }

    private boolean isMatch(boolean[][] visited, String str, int strIdx, String pattern, int patternIdx) {
        // fully consumed both, success
        if (strIdx >= str.length() && patternIdx >= pattern.length()) {
            return true;
        }

        // been here, i'm outtie
        if (visited[strIdx][patternIdx]) {
            return false;
        }

        visited[strIdx][patternIdx] = true;

        // we've run out of pattern
        if (strIdx < str.length() && patternIdx >= pattern.length()) {
            return false;
        }

        // if next pattern char is *, lets just move there and let it deal with it
        if (patternIdx + 1 < pattern.length() && pattern.charAt(patternIdx + 1) == '*') {
            return isMatch(visited, str, strIdx, pattern, patternIdx + 1);
        }

        // we may have run out of str by here, but we can continue if we can skip the rest of the pattern
        if (strIdx >= str.length()) {
            if (pattern.charAt(patternIdx) == '*') {
                // this is great, we can skip this
                return isMatch(visited, str, strIdx, pattern, patternIdx + 1);
            } else {
                return false;
            }
        }

        // otherwise, we have more to consume on both, lets see if we can

        if (pattern.charAt(patternIdx) == '*') {
            char prevPatternChar = pattern.charAt(patternIdx - 1);

            // if prevPatternChar matches or is '.', we can consume the string
            boolean matchFound = false;
            if (prevPatternChar == str.charAt(strIdx) || prevPatternChar == '.') {
                matchFound = isMatch(visited, str, strIdx + 1, pattern, patternIdx) ||
                    isMatch(visited, str, strIdx + 1, pattern, patternIdx + 1);
            }

            if (!matchFound) {
                // if we haven't ultimately found the correct answer, just skip the '*', who needs it
                matchFound = isMatch(visited, str, strIdx, pattern, patternIdx + 1);
            }

            return matchFound;
        }

        // now, current is not '*' and neither is next. so we're dealing with simple cases
        char currentPattern = pattern.charAt(patternIdx);
        if (currentPattern == str.charAt(strIdx) || currentPattern == '.') {
            return isMatch(visited, str, strIdx + 1, pattern, patternIdx + 1);
        }

        return false;
    }
}