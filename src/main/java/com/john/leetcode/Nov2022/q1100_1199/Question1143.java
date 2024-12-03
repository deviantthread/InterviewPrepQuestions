package com.john.leetcode.Nov2022.q1100_1199;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question1143 {
    //2 dim DP
    public int longestCommonSubsequence(String text1, String text2) {

        int[][] mem = new int[text1.length()][text2.length()];
        for (int[] memRow : mem) {
            Arrays.fill(memRow, -1);
        }

        return findLongestWith2DP(text1, 0, text2, 0, mem);
    }

    private int findLongestWith2DP(String text1, int idx1, String text2, int idx2, int[][] mem) {
        if (idx1 == text1.length() || idx2 == text2.length()) {
            return 0;
        } else if (mem[idx1][idx2] >= 0) {
            return mem[idx1][idx2];
        }

        if (text1.charAt(idx1) == text2.charAt(idx2)) {
            //match a char, +1 and move both pointers up
            int longest = 1 + findLongestWith2DP(text1, idx1 + 1, text2, idx2 + 1, mem);
            mem[idx1][idx2] = longest;

            return longest;
        }

        //otherwise, they don't match, need to try moving both pointers
        int longest = Math.max(findLongestWith2DP(text1, idx1 + 1, text2, idx2, mem),
            findLongestWith2DP(text1, idx1, text2, idx2 + 1, mem));

        mem[idx1][idx2] = longest;
        return longest;
    }

    public int longestCommonSubsequence1DP(String text1, String text2) {
        // pick all letters in text1. try to find it in text2,
        // pick all letters in text1 without 1 letter. try to find it in text 2.
        // pick all letters in text1 without n letters. try to find it in text2

        // as soon as we find one of these, thats the longest. if we get down to skipping all, return 0

        for (int skip = 0; skip < text1.length(); skip++) {
            int len = findLongestCommonSubsequence(text1, text2, "", 0, 0, skip);
            if (len > 0) {
                return len;
            }
        }

        return 0;
    }

    private int findLongestCommonSubsequence(String text1, String text2, String curr, int idx, int currSkip, int maxSkip) {
        // once we reach the end, see if the string we created exists in text2
        if (idx >= text1.length()) {
            return containsSubsequence(text2, curr) ? curr.length() : 0;
        }

        int maxLen = 0;

        // if we're allowed to skip this letter, skip it
        if (currSkip < maxSkip) {
            maxLen = findLongestCommonSubsequence(text1, text2, curr, idx + 1, currSkip + 1, maxSkip);
        }

        // but also try to keep it
        maxLen = Math.max(maxLen, findLongestCommonSubsequence(text1, text2, curr + text1.charAt(idx), idx + 1, currSkip, maxSkip));

        return maxLen;
    }

    private boolean containsSubsequence(String text, String curr) {
        int textIdx = 0;
        int currIdx = 0;

        while (textIdx < text.length() && currIdx < curr.length()) {
            if (curr.charAt(currIdx) == text.charAt(textIdx)) {
                //the match, move both cursors up
                textIdx++;
                currIdx++;
            } else {
                //try to find curr's char later in the text
                textIdx++;
            }
        }

        // if we made it to the end of curr, we win
        return currIdx == curr.length();
    }

    public int longestCommonSubsequenceGenerateAll(String text1, String text2) {

        // O(n)   - find overlapping chars
        // O(2^n) - build all subsequences for both text1 and text2 for just those chars
        // O(n)   - find matching subsequences
        // O(n)   - choose longest

        Set<Character> text1Chars = new HashSet<>();
        for (char c : text1.toCharArray()) {
            text1Chars.add(c);
        }

        Set<Character> overlappingChars = new HashSet<>();

        for (char c : text2.toCharArray()) {
            if (text1Chars.contains(c)) {
                overlappingChars.add(c);
            }
        }

        Set<String> text1Subsequences = buildSubsequences(text1, overlappingChars);
        Set<String> text2Subsequences = buildSubsequences(text2, overlappingChars);

        int maxLen = 0;

        for (String subsequence : text1Subsequences) {
            if (text2Subsequences.contains(subsequence)) {
                maxLen = Math.max(maxLen, subsequence.length());
            }
        }

        return maxLen;
    }

    private Set<String> buildSubsequences(String text, Set<Character> overlappingChars) {
        List<List<String>> visited = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            visited.add(new ArrayList<>());
        }

        List<String> allSubsequences = findAllSubsequences(text, overlappingChars, visited, 0);

        Set<String> ret = new HashSet<>();
        ret.addAll(allSubsequences);

        return ret;
    }

    private List<String> findAllSubsequences(String text, Set<Character> overlappingChars, List<List<String>> visited, int idx) {
        if (idx >= text.length()) {
            return new ArrayList<>();
        } else if (!visited.get(idx).isEmpty()) {
            return visited.get(idx);
        }

        List<String> subsequences = findAllSubsequences(text, overlappingChars, visited, idx + 1);

        List<String> curr = new ArrayList<>();
        curr.add(String.valueOf(text.charAt(idx)));

        //take the char and prepend it
        if (overlappingChars.contains(text.charAt(idx))) {
            for (String subsequence : subsequences) {
                curr.add(text.charAt(idx) + subsequence);
            }
        }

        //also choose to skip it
        curr.addAll(subsequences);

        visited.get(idx).addAll(curr);
        return curr;
    }
}
