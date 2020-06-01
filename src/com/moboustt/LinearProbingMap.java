package com.moboustt;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class LinearProbingMap {
    private static class Entry{
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Entry[] entries;

    public LinearProbingMap(int capacity){
        entries = new Entry[capacity];
    }

    public void put(int key, String value){
        int index = hash(key);
        for (int i = 0; i < entries.length; i++) {
            if (entries[index] == null) {
                entries[index] = new Entry(key, value);
                return;
            }
            index = index + i % entries.length;
        }
    }

    public String get(int key){
        var index = hash(key);
        for (var entry : entries)
            if (entry.key == key)
                return entry.value;
            throw new IllegalStateException();
    }

    private int hash(int key) {
        return key % entries.length;
    }

    @Override
    public String toString() {
        return Arrays.toString(entries);
    }
}
