package com.moboustt;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
    private int[] items = new int[5];
    private int count = 0;

    // push()
    public void push(int item){
        // O(1)
        if (items.length == count) throw new StackOverflowError();
        items[count++] = item;
    }
    // pop()
    // O(1)
    public int pop(){
        if (isEmpty()) throw new EmptyStackException();
        return items[--count];
    }

    // peek()
    // O(1)
    public int peek(){
        if (isEmpty()) throw new EmptyStackException();
        return items[--count];
    }

    // isEmpty()
    // O(1)
    public boolean isEmpty(){
        return count == 0;
    }

    @Override
    public String toString() {
        // O(n)
        var copy = Arrays.copyOfRange(items, 0, count);
        return Arrays.toString(copy);
    }
}
