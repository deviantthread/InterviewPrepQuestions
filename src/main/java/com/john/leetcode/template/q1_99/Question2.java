package com.john.leetcode.template.q1_99;

import com.john.datastructures.ListNode;

public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode preHead = new ListNode(-1);
        ListNode curr = preHead;

        int carry = 0;
        while (l1 != null || l2 != null) {
            int val = carry;
            if (l1 != null) {
                val += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                val += l2.val;
                l2 = l2.next;
            }

            if (val >= 10) {
                val -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            curr.next = new ListNode(val);
            curr = curr.next;
        }

        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return preHead.next;
    }
}
