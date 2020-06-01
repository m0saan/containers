package com.moboustt;

import java.util.LinkedList;

public class HashTable {

    private LinkedList<Entry>[] entries;

    public HashTable(int capacity) {
        entries = new LinkedList[capacity];
    }

    // put(k,v)
    public void put(int key, String value) {
        var index = hashFunction(key);
        if (entries[index] == null)
            entries[index] = new LinkedList<>();

        var bucket = entries[index];
        for (var entry : bucket)
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        bucket.addLast(new Entry(key, value));
    }

    // get(k) : v
    public String get(int key) {
        var entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    // remove(k)
    public void remove(int key) {
        var entry = getEntry(key);
        if (entry == null) throw new IllegalStateException();
        var bucket = getBucket(key).remove(entry);
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

    private LinkedList<Entry> getBucket(int key){
        return entries[hashFunction(key)];
    }

    private int hashFunction(int key) {
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
