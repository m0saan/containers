package com.moboustt;

public class MinPriorityQueue {
    private MinHeap minHeap;

    public MinPriorityQueue(int capacity) {
        minHeap = new MinHeap(capacity);
    }

    // insert(String value, int key) -> void
    public void insert(String value , int key){
        minHeap.insert(key, value);
    }

    // remove() -> void
    public void remove(){
        minHeap.remove();
    }

    public boolean isEmpty() {
        return minHeap.isEmpty();
    }
}
