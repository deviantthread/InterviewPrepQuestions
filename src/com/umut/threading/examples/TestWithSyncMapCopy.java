package com.umut.threading.examples;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TestWithSyncMapCopy {

    final Map<String, Listener> listeners = Collections.synchronizedMap(new HashMap<String, Listener>());

    private final Thread mThreadAdd;
    private final Thread mThreadRemove;
    private final Thread mThreadIterate;

    TestWithSyncMapCopy() {
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
                    // TODO Auto-generated catch block
                    e.printStackTrace();
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
                    // TODO Auto-generated catch block
                    e.printStackTrace();
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

                // Copy the map
                Map<String, Listener> copyOfListeners = new HashMap<String, Listener>(mListeners);
                for (java.util.Map.Entry<String, Listener> entry : mListeners.entrySet()) {
                    copyOfListeners.put(entry.getKey(), entry.getValue().clone());
                }

                final Iterator<java.util.Map.Entry<String, Listener>> mapIterator = copyOfListeners.entrySet()
                        .iterator();
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
