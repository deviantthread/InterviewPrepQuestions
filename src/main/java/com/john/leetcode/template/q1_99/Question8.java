package com.john.leetcode.template.q1_99;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Question8 {
    public int myAtoi(String s) {
        char[] chars = s.toCharArray();
        int idx = 0;

        // skip initial whitespace
        while (idx < chars.length && Character.isWhitespace(chars[idx])) {
            idx++;
        }

        // skip + or - sign, but save is neg or not
        boolean isNeg = false;
        if (idx < chars.length && (chars[idx] == '+' || chars[idx] == '-')) {
            isNeg = chars[idx++] == '-';
        }

        //this string is buggin
        if (idx >= chars.length || !Character.isDigit(chars[idx])) {
            return 0;
        }

        // next chars should be digits
        int endIdx = idx;
        while (endIdx < chars.length && Character.isDigit(chars[endIdx])) {
            endIdx++;
        }

        //ran too far, back up
        endIdx--;

        int number = 0;
        try {
            number = Integer.parseInt(String.valueOf(chars, idx, endIdx - idx + 1));
            if (isNeg) {
                number = number * -1;
            }
        } catch (NumberFormatException e) {
            number = isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return number;
    }

    // passed
    public int myAtoiRegex(String s) {
        Pattern intPattern = Pattern.compile(" *(?<sign>[+\\-])?(?<number>[0-9]+)($|[^0-9].*)");

        Matcher matcher = intPattern.matcher(s);

        if (!matcher.matches()) {
            return 0;
        }

        String sign = matcher.group("sign");
        boolean isNegative = sign != null && sign.equals("-");

        int number = 0;
        try {
            number = Integer.parseInt(matcher.group("number"));

            if (isNegative) {
                number = number * -1;
            }
        } catch (NumberFormatException e) {
            number = isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }

        return number;
    }
}
