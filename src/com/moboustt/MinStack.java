package com.moboustt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;

public class MinStack{
    private int[][] arrayOfArrays;
    private int  capacity;
    private int top = -1;

    public MinStack(int capacity) {
        this.capacity = capacity;
        arrayOfArrays = new int[capacity][capacity];
    }
    /*
    public void pop(int item){
        if (isFull()) throw new IllegalArgumentException();
        if (isEmpty()){
            top += 1;
            arrayOfArrays[top][top] = {item, item};
        }
    }

     */

    public boolean isFull(){
        return top == capacity;
    }

    public boolean isEmpty(){
        return top == -1;
    }
}