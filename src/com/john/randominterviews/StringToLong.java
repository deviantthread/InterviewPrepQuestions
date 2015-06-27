package com.john.randominterviews;

public class StringToLong {

    public static void main(String[] args) {
        String num = String.valueOf(Long.MIN_VALUE);
        long l = new StringToLong().parseLong(num);
        System.out.println("val: " + l);
    }

    private long parseLong(String num) {
        num = removeWhitespace(num);
        validateNum(num);
        num = stripDecimalIfNeeded(num);

        if (num.length() == 0) {
            return 0L;
        }

        boolean isNeg = num.charAt(0) == '-';
        if (isNeg) {
            num = num.substring(1, num.length());
        }

        long ret = 0L;
        int exp = 0;
        for (int i = num.length() - 1; i >= 0; i--) {
            long digit = num.charAt(i) - '0';
            digit *= Math.pow(10, exp);

            verifyNoOverflow(ret, digit, isNeg);

            if (!isNeg) {
                ret += digit;
            } else {
                ret -= digit;
            }
            exp++;
        }

        return ret;
    }

    private void verifyNoOverflow(long ret, long digit, boolean isNeg) {
        if (!isNeg) {
            if (Long.MAX_VALUE - ret < digit) {
                throw new NumberFormatException("overflow max");
            }
        } else {
            if (Long.MIN_VALUE - ret > -digit) {
                throw new NumberFormatException("overflow min");
            }
        }
    }

    private String removeWhitespace(String num) {
        int whiteCount = 0;
        for (char c : num.toCharArray()) {
            if (c == ' ') {
                whiteCount++;
            }
        }

        char[] ary = new char[num.length() - whiteCount];

        int aryIdx = 0;
        for (char c : num.toCharArray()) {
            if (c != ' ') {
                ary[aryIdx++] = c;
            }
        }

        return new String(ary);
    }

    private String stripDecimalIfNeeded(String num) {
        int idx = num.indexOf('.');
        if (idx >= 0) {
            return num.substring(0, idx);
        }

        return num;
    }

    private void validateNum(String num) {
        boolean hasDecimal = false;

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            int digit = c - '0';
            if (digit >= 0 && digit <= 9) {
                // its a digit
            } else if (c == '.') {
                if (hasDecimal) {
                    throw new NumberFormatException("only one decimal place");
                }
                hasDecimal = true;
            } else if (c == '-') {
                if (i != 0) {
                    throw new NumberFormatException("can only put minus signs at the start");
                }
            } else {
                throw new NumberFormatException("invalid char: " + c);
            }
        }
    }
}
