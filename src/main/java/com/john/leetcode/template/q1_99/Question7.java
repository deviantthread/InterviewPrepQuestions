package com.john.leetcode.template.q1_99;

public class Question7 {
    // i think i can use some bit flipping crap to set individual digits in the result int
    // if i start reading the input int from the right side, bit shifting wise.
    // and then start building the output from the left side, bit shifting wise.
    // then flip the result if its neg

    public int reverse(int x) {
        boolean isNeg = x < 0;
        if (isNeg) {
            x *= -1;
        }

        int pos = 10;
        int prevPos = pos;
        while (pos <= x) {
            prevPos = pos;
            pos *= 10;

            if (pos / 10 != prevPos) {
                return 0;
            }
        }
        //went too far
        pos /= 10;

        int prevReversed = 0;
        int reversed = 0;
        while (x > 0) {
            int digit = x % 10;
            prevReversed = reversed;
            int curr = digit * pos;
            reversed += curr;

            // overflow check
            if (reversed < 0 || (reversed - curr) != prevReversed) {
                return 0;
            }

            x /= 10;
            pos /= 10;
        }

        if (isNeg) {
            reversed *= -1;
        }

        return reversed;
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
