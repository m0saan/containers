package com.moboustt;

import java.util.LinkedList;

public class AnotherHashTable {
    private LinkedList<Entry>[] entries;

    public AnotherHashTable(int capacity) {
        entries = new LinkedList[capacity];
    }

    // put(k, v)
    public void put(int key, String value) {
        var index = hash(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        var entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }

        entries[index].addLast(new Entry(key, value));
    }

    // get(k) -> v
    public String get(int key) {
        var entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    // remove(k)
    public void remove(int key) {
        var bucket = getBucket(key);
        var entry = getEntry(key);
        if (entry != null)
            bucket.remove(entry);
    }

    private Entry getEntry(int key) {
        var bucket = getBucket(key);
        if (bucket != null) {
            for (var entry : bucket)
                if (entry.key == key)
                    return entry;
        }
        return null;
    }

    private LinkedList<Entry> getBucket(int key) {
        return entries[hash(key)];
    }

    private int hash(int key) {
        return key % entries.length;
    }

    private static class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }
}
