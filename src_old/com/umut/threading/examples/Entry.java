package com.umut.threading.examples;

public class Entry {

    public static void main(String[] args) {

        // This should fail with CME
        if (false) {
            TestWithMapIterator testWithSyncMapIterator = new TestWithMapIterator();
            testWithSyncMapIterator.start();
        }

        // This should run fine
        if (false) {
            TestWithSyncMapCopy testWithSyncMapCopy = new TestWithSyncMapCopy();
            testWithSyncMapCopy.start();
        }

        // This should run fine
        if (true) {
            TestWithCopyOnWriteSet testWithCopyOnWriteSet = new TestWithCopyOnWriteSet();
            testWithCopyOnWriteSet.start();
        }

    }
}
