package com.john.Nov2022.leetcode.q200_299;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Question225 {
    public static class MyStack {
        Queue<Integer> push = new LinkedList<>();
        Queue<Integer> backup = new LinkedList<>();
        Integer top = null;

        public MyStack() {
        }

        public void push(int x) {
            top = x;
            push.offer(x);
        }

        public int pop() {
            top = null;
            Integer lastElem = null;
            while (!push.isEmpty()) {
                lastElem = push.poll();
                if (!push.isEmpty()) {
                    backup.offer(lastElem);
                }
            }

            if (lastElem != null) {
                return lastElem;
            }

            while (!backup.isEmpty()) {
                lastElem = backup.poll();
                if (!backup.isEmpty()) {
                    push.offer(lastElem);
                }
            }

            return lastElem;
        }

        public int top() {
            if (top != null) {
                return top;
            }

            top = pop();
            push(top);
            return top;
        }

        public boolean empty() {
            return push.isEmpty() && backup.isEmpty();
        }

        // cheating for tests
        public List<Integer> toList() {
            List<Integer> ret = new ArrayList<>();

            LinkedList<Integer> pushList = (LinkedList<Integer>) push;

            for (int i = pushList.size() - 1; i >= 0; i--) {
                ret.add(pushList.get(i));
            }

            LinkedList<Integer> backupList = (LinkedList<Integer>) backup;

            for (int i = backupList.size() - 1; i >= 0; i--) {
                ret.add(backupList.get(i));
            }

            return ret;
        }
    }
}
