package com.umut.threading.examples;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import com.google.common.collect.Maps;

public class TestWithCopyOnWriteSet {

    final CopyOnWriteArraySet<Map.Entry<String, Listener>> listeners = new CopyOnWriteArraySet<Map.Entry<String, Listener>>();

    private final Thread mThreadAdd1;
    private final Thread mThreadAdd2;
    private final Thread mThreadRemove1;
    private final Thread mThreadRemove2;
    private final Thread mThreadIterate1;
    private final Thread mThreadIterate2;

    TestWithCopyOnWriteSet() {

        listeners.add(Maps.immutableEntry("1", new Listener("1")));
        listeners.add(Maps.immutableEntry("2", new Listener("2")));
        listeners.add(Maps.immutableEntry("3", new Listener("3")));

        mThreadAdd1 = new AddThread(listeners);
        mThreadAdd2 = new AddThread(listeners);
        mThreadRemove1 = new RemoveThread(listeners);
        mThreadRemove2 = new RemoveThread(listeners);
        mThreadIterate1 = new IterateThread(listeners);
        mThreadIterate2 = new IterateThread(listeners);
    }

    public void start() {
        mThreadAdd1.start();
        mThreadAdd2.start();
        mThreadRemove1.start();
        mThreadRemove2.start();
        mThreadIterate1.start();
        mThreadIterate2.start();
    }

    public static class AddThread extends Thread {
        Set<Map.Entry<String, Listener>> mListeners;

        public AddThread(Set<Map.Entry<String, Listener>> listeners) {
            mListeners = listeners;
            setName("AddThread");
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Add");
                final int val = (int) (Math.random() * 100);
                final String sVal = String.valueOf(val);
                mListeners.add(Maps.immutableEntry(sVal, new Listener(sVal)));

                try {
                    sleep(20);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static class RemoveThread extends Thread {
        Set<Map.Entry<String, Listener>> mListeners;

        public RemoveThread(Set<Map.Entry<String, Listener>> listeners) {
            mListeners = listeners;
            setName("RemoveThread");
        }

        @Override
        public void run() {
            while (true) {
                final Iterator<Map.Entry<String, Listener>> mapIterator = mListeners.iterator();
                if (mapIterator.hasNext()) {
                    Map.Entry entry = mapIterator.next();
                    Map.Entry copiedEntry = Maps.immutableEntry(entry.getKey(), entry.getValue());

                    System.out.println("Remove" + (mListeners.remove(copiedEntry) ? "d succesfully" : " failed"));
                }

                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

    public static class IterateThread extends Thread {
        Set<Map.Entry<String, Listener>> mListeners;

        public IterateThread(Set<Map.Entry<String, Listener>> listeners) {
            mListeners = listeners;
            setName("IterateThread");
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Iterate");
                final Iterator<java.util.Map.Entry<String, Listener>> mapIterator = mListeners.iterator();
                while (mapIterator.hasNext()) {
                    final java.util.Map.Entry<String, Listener> entry = mapIterator.next();
                    System.out.println(entry.getValue());
                }

                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}
