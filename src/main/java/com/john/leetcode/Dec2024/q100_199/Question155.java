package com.john.leetcode.Dec2024.q100_199;

public class Question155 {

    //      Your MinStack object will be instantiated and called as such:
    //      MinStack obj = new MinStack();
    //      obj.push(val);
    //      obj.pop();
    //      int param_3 = obj.top();
    //      int param_4 = obj.getMin();

    public static class MinStack {

        private Node head = null;

        public MinStack() {
        }

        public void push(int val) {
            Node node = new Node(val);
            if (head == null) {
                head = node;
                head.nextMin = head;
            } else {
                if (node.val < head.nextMin.val) {
                    node.nextMin = node;
                } else {
                    node.nextMin = head.nextMin;
                }

                head.next = node;
                node.prev = head;
                head = node;
            }
        }

        public void pop() {
            if (head == null) {
                return;
            }

            head = head.prev;
        }

        public int top() {
            if (head == null) {
                throw new IllegalStateException("head is null");
            }

            return head.val;
        }

        public int getMin() {
            if (head == null) {
                throw new IllegalStateException("head is null");
            }
            return head.nextMin.val;
        }
    }

    private static class Node {
        public Node prev;
        public Node next;
        public Node nextMin;
        public int val;

        public Node(int val) {
            this.val = val;
        }
    }
}
