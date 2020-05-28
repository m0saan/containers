package com.moboustt;

import java.util.Arrays;

public class TwoStacks {
    private int[] items;
    private int capacity;
    private int top;
    private int bottom;

    public TwoStacks(int capacity) {
        this.capacity = capacity;
        items = new int[capacity];
        top = -1;
        bottom = capacity;

    }

    // push1
    public void push1(int item){
        if (isFull1()) throw new IllegalArgumentException();
        items[top += 1] = item;
    }

    // push2
    public void push2(int item){
        if (isFull2()) throw new IllegalArgumentException();
        items[bottom -= 1] = item;
    }

    // isEmpty
    public boolean isEmpty1(){
        return top == -1;
    }

    // isEmpty2
    public boolean isEmpty2(){
        return bottom == capacity;
    }

    // isFull1
    public boolean isFull1(){
        return bottom == top;
    }

    // isFull2
    public boolean isFull2(){
        return isFull1();
    }

    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
