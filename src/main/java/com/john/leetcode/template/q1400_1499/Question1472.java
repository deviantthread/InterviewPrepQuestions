package com.john.leetcode.template.q1400_1499;

import java.util.ArrayList;
import java.util.List;

public class Question1472 {
    public static class BrowserHistory {
        Node current;

        public BrowserHistory(String homepage) {
            this.current = new Node(homepage);
            this.current.back = this.current; // can't go back further
        }

        public void visit(String url) {
            Node newUrl = new Node(url, current);
            current.forward = newUrl;
            current = newUrl;
        }

        public String back(int steps) {
            for (int i = 0; i < steps; i++) {
                current = current.back;
            }

            return current.url;
        }

        public String forward(int steps) {
            for (int i = 0; i < steps && current.forward != null; i++) {
                current = current.forward;
            }
            return current.url;
        }

        public List<String> backToArray() {
            List<String> ret = new ArrayList<>();

            Node curr = this.current;

            while (curr.back != curr) {
                ret.add(0, curr.url);
                curr = curr.back;
            }
            ret.add(0, curr.url);

            return ret;
        }

        public List<String> forwardToArray() {
            List<String> ret = new ArrayList<>();

            Node curr = this.current;

            while (curr.forward != null) {
                ret.add(curr.url);
                curr = curr.forward;
            }

            return ret;
        }
    }

    private static class Node {
        private final String url;
        private Node back;
        private Node forward;

        public Node(String url) {
            this(url, null);
        }

        public Node(String url, Node back) {
            this.url = url;
            this.back = back;
        }
    }
}
