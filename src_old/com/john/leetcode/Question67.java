package com.john.leetcode;

public class Question67 {

    public static void main(String[] args) {
        String a = "11";
        String b = "11";
        System.out.println(new Question67().addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        char[] aa = a.toCharArray();
        char[] ba = b.toCharArray();
        int ai = aa.length - 1;
        int bi = ba.length - 1;

        String result = "";
        char carry = '0';
        while (ai >= 0 && bi >= 0) {
            int t = countOnes(aa[ai--], ba[bi--], carry);
            if (t == 0 || t == 1) {
                result = String.valueOf(t) + result;
                carry = '0';
            } else if (t == 2) {
                carry = '1';
                result = "0" + result;
            } else {
                carry = '1';
                result = "1" + result;
            }
        }

        while (ai >= 0) {
            int t = countOnes(aa[ai--], carry);
            if (t == 0 || t == 1) {
                result = String.valueOf(t) + result;
                carry = '0';
            } else if (t == 2) {
                carry = '1';
                result = "0" + result;
            } else {
                carry = '1';
                result = "1" + result;
            }
        }

        while (bi >= 0) {
            int t = countOnes(ba[bi--], carry);
            if (t == 0 || t == 1) {
                result = String.valueOf(t) + result;
                carry = '0';
            } else if (t == 2) {
                carry = '1';
                result = "0" + result;
            } else {
                carry = '1';
                result = "1" + result;
            }
        }

        if (carry == '1') {
            result = "1" + result;
        }

        return result;
    }

    private int countOnes(Character... chars) {
        int ones = 0;
        for (Character c : chars) {
            if (c == '1') {
                ones++;
            }
        }
        return ones;
    }

}
