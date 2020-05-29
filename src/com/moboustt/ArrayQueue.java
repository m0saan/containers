package com.moboustt;

import java.util.Arrays;

public class ArrayQueue {
    private int[] items;
    private int capacity;
    private int front = 0;
    private int rear = 0;
    private int size = 0;

    public ArrayQueue(int capacity) {
        items = new int[capacity];
        this.capacity = capacity;
    }

    public void enqueue(int item){
        if (isFull()) throw new IllegalArgumentException();
        items[rear] = item;
        rear = (rear + 1) % capacity;
        size++;
    }

    public int dequeue(){
        if (isEmpty()) throw new IllegalArgumentException();
        int removed = items[front];
        items[front] = 0;
        front = (front += 1) % capacity;
        size--;
        return removed;
    }

    public int peek(){
        return items[front];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){ return size == capacity ;}

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
