package com.moboustt;

import java.util.Arrays;
import java.util.Collections;

public class TwoStacks {
    private int[] items;
    private int stack1Capacity;
    private int stack2Capacity;
    private int top;
    private int bottom;

    public TwoStacks(int firstStackCapacity, int secondStackCapacity) {
        stack1Capacity = firstStackCapacity;
        stack2Capacity = secondStackCapacity;
        items = new int[stack1Capacity + stack2Capacity];
        top = -1;
        bottom = stack1Capacity + stack2Capacity;

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

    // pop1
    public int pop1(){
        if (isEmpty1()) throw new IllegalArgumentException();
        return items[top -= 1];
    }

    // pop2
    public int pop2(){
        if (isEmpty2()) throw new IllegalArgumentException();
        return items[bottom -= 1];
    }

    // isEmpty
    public boolean isEmpty1(){
        return top == -1;
    }

    // isEmpty2
    public boolean isEmpty2(){
        return bottom == stack1Capacity + stack2Capacity;
    }

    // isFull1
    public boolean isFull1(){
        return top == stack1Capacity - 1;
    }

    // isFull2
    public boolean isFull2(){
        return bottom == stack2Capacity;
    }

    public void printStacks1(){
        var list = new java.util.ArrayList<>(Collections.emptyList());
        for (int i = 0; i < stack1Capacity ; i++)
                list.add(items[i]);
        System.out.println(list);
    }
    public void printStacks2(){
        var list = new java.util.ArrayList<>(Collections.emptyList());
        for (int i = 0; i + stack2Capacity < stack1Capacity + stack2Capacity ; i++)
                list.add(items[i + stack1Capacity]);
        System.out.println(list);
    }
}
