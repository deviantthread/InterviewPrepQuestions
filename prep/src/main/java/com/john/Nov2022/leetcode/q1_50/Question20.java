package com.john.Nov2022.leetcode.q1_50;

import java.util.Stack;

public class Question20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] parens = s.toCharArray();

        for (char paren : parens) {
            if (isOpenParen(paren)) {
                stack.push(paren);
            } else if (closeParenMatchesTopOfStack(paren, stack)) {
                stack.pop();
            } else {
                // either it wasn't an open paren (err) or close paren didn't match what was on top of stack
                return false;
            }
        }

        // if we cleared off the entire stack, we good
        return stack.isEmpty();
    }

    private boolean closeParenMatchesTopOfStack(char closeParen, Stack<Character> stack) {
        if (stack.isEmpty()) {
            return false;
        }

        Character lastOpenParen = stack.peek();

        switch (closeParen) {
            case ')':
                return lastOpenParen == '(';
            case ']':
                return lastOpenParen == '[';
            case '}':
                return lastOpenParen == '{';
            default:
                return false;
        }
    }

    private boolean isOpenParen(char paren) {
        return paren == '(' ||
            paren == '[' ||
            paren == '{';
    }
}
