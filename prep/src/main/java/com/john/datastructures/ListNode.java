package com.john.datastructures;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

@Slf4j
@RequiredArgsConstructor
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public void print() {
        printNodes(this);
    }

    public static ListNode create(int[] values) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        for (int value : values) {
            curr.next = new ListNode(value);
            curr = curr.next;
        }

        return head.next;
    }

    /**
     * format is "[1,4,3,2,5,2]"
     */
    public static ListNode create(String list) {
        if (list.equals("[]")) {
            return null;
        }
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        String trimmed = StringUtils.removeEnd(StringUtils.removeStart(list, "["), "]");
        Iterable<String> nums = Splitter.on(",").split(trimmed);

        for (String num : nums) {
            curr.next = new ListNode(Integer.parseInt(num));
            curr = curr.next;
        }
        return head.next;
    }

    public int[] toArray() {
        return toArray(this);
    }

    public static int[] toArray(ListNode head) {
        List<Integer> result = new ArrayList<>();

        while (head != null) {
            result.add(head.val);
            head = head.next;
        }

        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void printNodes(ListNode head) {
        if (head == null) {
            return;
        }

        System.out.println(head.toString());
    }

    public ListNode getTail() {
        ListNode curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }

        return curr;
    }

    public ListNode getIndex(int idx) {
        ListNode curr = this;
        for (int i = 0; i < idx; i++) {
            curr = curr.next;
        }
        return curr;
    }

    @Override
    public String toString() {
        int[] ints = ListNode.toArray(this);

        String joined = Joiner.on(",").join(Arrays.stream(ints).iterator());
        return String.format("[%s]", joined);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof ListNode)) {
            return false;
        }

        int[] thisVals = this.toArray();
        int[] objVals = ((ListNode) obj).toArray();
        if (thisVals.length != objVals.length) {
            return false;
        }

        for (int i = 0; i < thisVals.length; i++) {
            if (thisVals[i] != objVals[i]) {
                return false;
            }
        }
        return true;
    }

    public int length() {
        int len = 0;

        ListNode curr = this;

        while (curr != null) {
            len++;
            curr = curr.next;
        }

        return len;
    }
}
