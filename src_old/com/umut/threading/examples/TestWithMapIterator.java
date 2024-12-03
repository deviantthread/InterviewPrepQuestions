package com.umut.threading.examples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Throwables;

public class TestWithMapIterator {

    final Map<String, Listener> listeners = new HashMap<String, Listener>();

    private final Thread mThreadAdd;
    private final Thread mThreadRemove;
    private final Thread mThreadIterate;

    TestWithMapIterator() {
        listeners.put("1", new Listener("1"));
        listeners.put("2", new Listener("2"));
        listeners.put("3", new Listener("3"));

        mThreadAdd = new AddThread(listeners);
        mThreadRemove = new RemoveThread(listeners);
        mThreadIterate = new IterateThread(listeners);
    }

    public void start() {
        mThreadAdd.start();
        mThreadRemove.start();
        mThreadIterate.start();
    }

    public static class AddThread extends Thread {
        Map<String, Listener> mListeners;

        public AddThread(Map<String, Listener> listeners) {
            mListeners = listeners;
            setName("AddThread");
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Put");
                final int val = (int) (Math.random() * 100);
                final String sVal = String.valueOf(val);
                mListeners.put(sVal, new Listener(sVal));

                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    Throwables.propagate(e);
                    // e.printStackTrace();
                }
            }
        }
    }

    public static class RemoveThread extends Thread {
        Map<String, Listener> mListeners;

        public RemoveThread(Map<String, Listener> listeners) {
            mListeners = listeners;
            setName("RemoveThread");
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Remove");
                final Iterator<java.util.Map.Entry<String, Listener>> mapIterator = mListeners.entrySet().iterator();
                if (mapIterator.hasNext()) {
                    mListeners.remove(mapIterator.next().getKey());
                }

                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    Throwables.propagate(e);
                    // e.printStackTrace();
                }
            }
        }
    }

    public static class IterateThread extends Thread {
        Map<String, Listener> mListeners;

        public IterateThread(Map<String, Listener> listeners) {
            mListeners = listeners;
            setName("IterateThread");
        }

        @Override
        public void run() {
            while (true) {
                System.out.println("Iterate");
                final Set<Map.Entry<String, Listener>> entrySet = mListeners.entrySet();
                final Iterator<Map.Entry<String, Listener>> mapIterator;
                synchronized (mListeners) {
                    mapIterator = mListeners.entrySet().iterator();
                }

                while (mapIterator.hasNext()) {
                    final java.util.Map.Entry<String, Listener> entry = mapIterator.next();
                    System.out.println(entry.getValue());
                }

                try {
                    sleep(10);
                } catch (InterruptedException e) {
                    // Throwables.propagate(e);
                    e.printStackTrace();
                }
            }
        }
    }

}
