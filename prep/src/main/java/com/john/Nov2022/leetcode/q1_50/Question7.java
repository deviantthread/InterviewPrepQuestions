package com.john.Nov2022.leetcode.q1_50;

public class Question7 {
    // i think i can use some bit flipping crap to set individual digits in the result int
    // if i start reading the input int from the right side, bit shifting wise.
    // and then start building the output from the left side, bit shifting wise.
    // then flip the result if its neg

    public int reverse(int x) {
        return 0;
    }

    public int reverseStr(int x) {
        boolean isNeg = x < 0;
        if (isNeg) {
            x = x * -1;
        }
        char[] chars = String.valueOf(x).toCharArray();

        reverseArray(chars);
        int result = Integer.parseInt(new String(chars));
        if (isNeg) {
            result = result * -1;
        }

        return result;
    }

    private void reverseArray(char[] chars) {

        int i = 0;
        int j = chars.length - 1;

        while (i < j) {
            char tmp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = tmp;
        }
    }
}
