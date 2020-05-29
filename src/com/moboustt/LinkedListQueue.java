package com.moboustt;

import java.util.ArrayList;

public class LinkedListQueue extends LinkedList {

    // enqueue - O(1)
    public void enqueue(int item){ addLast(item); }

    // dequeue - O(1)
    public int dequeue(){ return popFirst(); }

    // peek - O(1)
    public int peek(){ return getFirst(); }

    // size - O(1)
    public int sizeOf() { return size(); }
    // isEmpty - O(1)
    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    public ArrayList<Integer> printQueue() {
        return super.printList();
    }
}
