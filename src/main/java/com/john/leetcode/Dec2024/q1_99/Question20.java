package com.john.leetcode.Dec2024.q1_99;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Question20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> matches = new HashMap<>();
        matches.put(')', '(');
        matches.put(']', '[');
        matches.put('}', '{');

        for (char c : s.toCharArray()) {
            // open paren, push it
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
                // matched closing paren to top of stack, pop it
            } else if (!stack.isEmpty() && stack.peek() == matches.get(c)) {
                stack.pop();
            } else {
                // unmatched closing paren
                return false;
            }
        }

        // everything is balanced if we've matched everything
        return stack.isEmpty();
    }
}