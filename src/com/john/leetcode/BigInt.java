package com.john.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BigInt {
    public static void main(String[] args) {
        String num = "10";
        int num2 = 18;

        BigInt bigInt = new BigInt(num);
        BigInt bigInt2 = new BigInt(num2);

        System.out.print(bigInt.subtract(bigInt2));
    }

    List<Integer> list = new ArrayList<Integer>();
    private boolean isNeg = false;

    public BigInt() {
        this(0);
    }

    public BigInt(String num) {
        if (num == null || num.equals("")) {
            num = "0";
        }

        StringBuilder sb = new StringBuilder();
        for (char c : num.toCharArray()) {
            if (Character.isDigit(c) || c == '-') {
                sb.append(c);
            }
        }
        convertToBig(sb.toString());
    }

    public BigInt(int num) {
        convertToBig(String.valueOf(num));
    }

    private void convertToBig(String num) {
        for (int i = num.length() - 1; i > 0; i--) {
            list.add(Integer.parseInt(num.substring(i, i + 1)));
        }

        if (num.substring(0, 1).equals("-")) {
            this.isNeg = true;
        } else {
            list.add(Integer.parseInt(num.substring(0, 1)));
        }

        trimZeros();
    }

    private void trimZeros() {
        for (int i = list.size() - 1; i > 0; i--) {
            if (list.get(i) == 0) {
                list.remove(i);
            } else {
                break;
            }
        }

    }

    public BigInt add(BigInt num) {
        if (num == null) {
            return this;
        } else if (num.isNeg) {
            num.invert();
            subtract(num);
            return this;
        }

        int max = Math.max(list.size(), num.list.size());
        int carry = 0;
        for (int i = 0; i < max; i++) {
            int sum = getDigit(i) + num.getDigit(i) + carry;
            carry = sum / 10;
            sum %= 10;
            setDigit(i, sum);
        }

        if (carry != 0) {
            list.add(carry);
        }

        trimZeros();
        return this;
    }

    // has problems when the num > this
    public BigInt subtract(BigInt num) {
        if (num == null) {
            return this;
        }
        if (num.isNeg) {
            num.invert();
            add(num);
            return this;
        }

        int max = Math.max(list.size(), num.list.size());
        for (int i = 0; i < max; i++) {
            int thisDigit = getDigit(i);
            int otherDigit = num.getDigit(i);
            if (thisDigit >= otherDigit) {
                // 7 - 5
                setDigit(i, thisDigit - otherDigit);
            } else if (canBorrow(i + 1)) {// maybe memoize this?
                // 12 - 5
                borrow(i + 1);
                setDigit(i, thisDigit + 10 - otherDigit);
            } else {
                // 2 - 7
                setDigit(i, Math.abs(thisDigit - otherDigit));
                this.isNeg = true;
            }
        }

        trimZeros();
        return this;
    }

    private void invert() {
        this.isNeg = !this.isNeg;
    }

    private int getDigit(int i) {
        if (i < list.size()) {
            return list.get(i);
        }

        return 0;
    }

    private void setDigit(int idx, int val) {
        if (idx < list.size()) {
            list.set(idx, val);
        } else if (list.size() == idx) {
            list.add(val);
        } else {
            throw new RuntimeException("seems wrong, idx: " + idx + " list.size: " + list.size());
        }
    }

    private boolean canBorrow(int idx) {
        for (int i = idx; i < list.size(); i++) {
            if ((i) > 0) {
                return true;
            }
        }
        return false;
    }

    private void borrow(int startIdx) {
        for (int i = startIdx; i < list.size(); i++) {
            int val = getDigit(i);
            if (val > 0) {
                setDigit(i, val - 1);
                break;
            } else {
                setDigit(i, 9);
            }
        }

    }

    public void multiply(BigInt num) {
        if (num == null) {
            return;
        }

    }

    public void divide(BigInt num) {
        if (num == null) {
            return;
        }

    }

    public int toInt() {
        String val = toString(false);
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            throw e;// anything better?
        }
    }

    @Override
    public String toString() {
        return toString(true);
    }

    private String toString(boolean withCommas) {
        StringBuilder sb = new StringBuilder();
        if (isNeg) {
            sb.append("-");
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            sb.append(getDigit(i));
            if (withCommas && i > 0 && i % 3 == 0) {
                sb.append(",");
            }
        }

        return sb.toString();
    }

}
