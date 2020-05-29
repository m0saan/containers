package com.moboustt;

import java.util.Stack;

public class QueueWithTwoStacks {
    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
    private int size = 0;

    // O(1)
    public void enqueue(int item){
        stack1.add(item);
        size++;
    }

    // O(n)
    public int dequeue(){
        if (isEmpty()) throw new IllegalStateException();
        if (stack2.isEmpty())
            while(!stack1.isEmpty())
                stack2.push(stack1.pop());
        return stack2.pop();
    }

    public boolean isEmpty() { return stack1.isEmpty() && stack2.isEmpty();}
}
