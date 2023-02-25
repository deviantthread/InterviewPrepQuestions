package com.john.Nov2022.leetcode.q1_99;

import java.util.ArrayList;
import java.util.List;

public class Question22 {
    public List<String> generateParenthesis(int n) {
        //        3 - >
        // all comes down to the number of open parens and what order we do them in.
        // then we just need to close em to stay balanced
        // 3 opens         ((()))
        // 2 then 1        (())()
        // 1 then 2        ()(())
        // 1 then 1 then 1 ()()()

        // this screams recursion to me. n - n, then n - (n-1) then n - (n-2). lets get the recursion to print out the numbers first
        List<String> ret = new ArrayList<>();

        generateParenthesis(n, n, ret, "");
        return ret;
    }

    private void generateParenthesis(int openRemaining, int closeRemaining, List<String> ret, String parens) {
        if (openRemaining == 0 && closeRemaining == 0) {
            ret.add(parens);
            return;
        }

        if (openRemaining > 0) {
            generateParenthesis(openRemaining - 1, closeRemaining, ret, parens + "(");
        }

        if (closeRemaining > openRemaining) {
            generateParenthesis(openRemaining, closeRemaining - 1, ret, parens + ")");
        }
    }
}
