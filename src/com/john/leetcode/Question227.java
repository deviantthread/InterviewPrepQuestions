package com.john.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Question227 {

    public static void main(String[] args) {
        String s = "0-2147483648";
        System.out.println(new Question227().calculate(s));
    }

    public int calculate(String s) {
        Set<String> multDivOps = new HashSet<String>();
        multDivOps.add("*");
        multDivOps.add("/");
        Set<String> addSubOps = new HashSet<String>();
        addSubOps.add("+");
        addSubOps.add("-");

        List<String> expr = breakNum(s);
        expr = combine(expr, multDivOps);
        expr = combine(expr, addSubOps);

        return parseInteger(expr.get(0));
    }

    private List<String> breakNum(String s) {
        List<String> ret = new ArrayList<String>();
        String currNum = "";
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                currNum += c;
            } else {
                if (!currNum.equals("")) {
                    ret.add(currNum);
                    currNum = "";
                }
                if (c != ' ') {
                    ret.add(String.valueOf(c));
                }
            }
        }

        if (!currNum.equals("")) {
            ret.add(currNum);
        }

        return ret;
    }

    private List<String> combine(List<String> expr, Set<String> operators) {
        List<String> ret = new ArrayList<String>();
        for (int i = 0; i < expr.size(); i++) {
            if (operators.contains(expr.get(i))) {
                int lhs = parseInteger(expr.get(i - 1));
                int rhs = parseInteger(expr.get(i + 1));
                int num = doOperations(expr.get(i), rhs, lhs);

                expr.remove(i + 1);
                expr.remove(i);
                expr.set(i - 1, String.valueOf(num));
                i -= 2;
                ret.remove(ret.size() - 1);
            } else {
                ret.add(expr.get(i));
            }
        }

        return ret;
    }

    private int parseInteger(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            if (num.equals(String.valueOf(Integer.MAX_VALUE))) {
                return Integer.MAX_VALUE;
            } else if (("-" + num).equals(String.valueOf(Integer.MIN_VALUE))) {
                return Integer.MIN_VALUE;
            } else {
                throw e;
            }
        }
    }

    private int doOperations(String op, int rhs, int lhs) {
        switch (op.charAt(0)) {
            case '*':
                return lhs * rhs;
            case '/':
                return lhs / rhs;
            case '+':
                return lhs + rhs;
            case '-':
                return lhs - rhs;
            default:
                throw new RuntimeException("invalid op:" + op);
        }
    }

}
