package com.john.leetcode.template.q700_799;

public class Question707 {
    public static class MyLinkedList {
        private int size = 0;
        private Node<Integer> head = null;

        public MyLinkedList() {

        }

        public int get(int index) {
            if (index < 0 || index >= size) {
                return -1;
            }

            Node<Integer> curr = head;
            for (int i = 0; i < index; i++) {
                curr = curr.next;
            }

            return curr.val;
        }

        public void addAtHead(int val) {
            head = new Node<>(val, head);

            size++;
        }

        public void addAtTail(int val) {
            if (head == null) {
                head = new Node<>(val);
            } else {
                Node<Integer> curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = new Node<>(val);
            }

            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index < 0 || index > size) {
                return;
            }

            if (index == 0) {
                head = new Node<>(val, head);
            } else {
                Node<Integer> prev = null;
                Node<Integer> curr = head;
                for (int i = 0; i < index; i++) {
                    prev = curr;
                    curr = curr.next;
                }
                prev.next = new Node<>(val, curr);
            }

            size++;
        }

        public void deleteAtIndex(int index) {
            if (index < 0 || index >= size) {
                return;
            }

            if (index == 0) {
                head = head.next;
            } else {
                Node<Integer> prev = null;
                Node<Integer> curr = head;
                for (int i = 0; i < index; i++) {
                    prev = curr;
                    curr = curr.next;
                }

                prev.next = curr.next;
            }

            size--;
        }

        public int[] toArray() {
            int[] ary = new int[size];

            Node<Integer> curr = head;
            for (int i = 0; i < size; i++) {
                ary[i] = curr.val;
                curr = curr.next;
            }

            return ary;
        }
    }

    private static class Node<T> {
        private final T val;
        private Node<T> next;

        public Node(T val, Node<T> next) {
            this.val = val;
            this.next = next;
        }

        public Node(T val) {
            this(val, null);
        }
    }
}
