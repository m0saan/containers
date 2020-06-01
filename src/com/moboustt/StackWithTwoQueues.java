package com.moboustt;

public class StackWithTwoQueues {
    private final ArrayQueue queue1;
    private final ArrayQueue queue2;
    private int size;

    public StackWithTwoQueues(int capacity) {
        queue1 = new ArrayQueue(capacity);
        queue2 = new ArrayQueue(capacity);
    }

    public void push(int item) {
        queue1.enqueue(item);
        size++;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException();
        pushStack1ToStack2();
        size -= 1;
        return queue2.dequeue();
    }


    public int peek() {
        if (isEmpty()) throw new IllegalStateException();
        pushStack1ToStack2();
        return queue2.peek();
    }

    private void pushStack1ToStack2() {
        if (queue2.isEmpty())
            while (!queue1.isEmpty())
                queue2.enqueue(queue1.dequeue());
    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public boolean isFull() {
        return queue1.isFull();
    }

    public int size(){
        return size;
    }

}
