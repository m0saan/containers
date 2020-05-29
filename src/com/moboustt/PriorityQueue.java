package com.moboustt;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items;
    private int rear = 0;
    private int first = 0;

    public PriorityQueue(int capacity){
        items = new int[capacity];
    }

    // [1,3,5,7] 2

    public void enqueue(int item){
        if (isFull()) throw new IllegalStateException();
        int index = shiftItemsToInsert(item);
        items[index] = item;
        rear++;
    }

    private int shiftItemsToInsert(int item) {
        var index = rear - 1;
        while (index >= 0){
            if (items[index] > item) {
                items[index + 1] = items[index];
            }
            else break;
            index--;
        }
        return index + 1;
    }

    public int dequeue(){
        if (isEmpty()) throw new IllegalStateException();
        return items[first++];
    }

    public boolean isFull() { return rear == items.length; }
    public boolean isEmpty() { return rear == 0; }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
