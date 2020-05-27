package com.moboustt;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedListStack extends LinkedList{

    // push()
    // O(1)
    public void push(int item){
        addFirst(item);
    }

    // pop()
    public int pop(){
        if (isEmpty()) throw new IllegalArgumentException();
        return popFirst();
    }

    // peek()
    // O(1)
    public int peek(){
        if (isEmpty()) throw new IllegalArgumentException();
        return getFirst();
    }

    // isEmpty()
    // O(1)
    public boolean isEmpty(){
        return size() == 0;
    }

    @Override
    public String toString() {
        return String.valueOf(printList());
    }
}
