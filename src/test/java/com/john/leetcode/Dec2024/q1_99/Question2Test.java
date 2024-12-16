package com.john.leetcode.Dec2024.q1_99;

import com.john.datastructures.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class Question2Test {
    private Question2 classUnderTest = new Question2();

    @Test
    public void testSameLength() {
        runTest(123, 234);
    }

    @Test
    public void testDifferentLength() {
        runTest(123, 23);
    }

    @Test
    public void testCarry() {
        runTest(4, 9);
    }

    @Test
    public void testMultiCarry() {
        runTest(99, 99);
    }

    @Test
    public void testZero() {
        runTest(15, 0);
    }

    private void runTest(int a, int b) {
        ListNode aList = createList(a);
        ListNode bList = createList(b);

        ListNode result = classUnderTest.addTwoNumbers(aList, bList);
        int value = reverseSum(result);

        Assert.assertEquals(a + b, value);
    }

    private int reverseSum(ListNode result) {
        int[] digits = result.toArray();
        int sum = 0;

        for (int i = 0; i < digits.length; i++) {
            sum += digits[i] * Math.pow(10, i);
        }

        return sum;
    }

    private ListNode createList(int value) {
        String strValue = String.valueOf(value);
        int[] digits = new int[strValue.length()];

        int digit = digits.length - 1;
        for (int valueIdx = 0; valueIdx < strValue.length(); valueIdx++) {
            digits[digit--] = Integer.parseInt(strValue.substring(valueIdx, valueIdx + 1));
        }

        return ListNode.create(digits);
    }
}