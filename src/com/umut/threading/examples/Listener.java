package com.umut.threading.examples;

public class Listener {

    private final String val;

    public Listener(String val) {
        this.val = val;
    }

    @Override
    public Listener clone() {
        return new Listener(val);
    }

    @Override
    public String toString() {
        return "Listener: " + String.valueOf(val);
    }
}
