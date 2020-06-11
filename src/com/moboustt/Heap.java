package com.moboustt;

import java.util.Arrays;

public class Heap {
    private int[] items;
    private int size;

    public Heap(int capacity) {
        items = new int[capacity];
    }

    // insert(int value)
    public void insert(int value) {
        if (isFull()) throw new IllegalStateException();

        items[size++] = value;
        bubbleUp();
    }

    // remove()
    public int remove() {
        if (isEmpty()) throw new IllegalStateException();
        var root = items[0];
        items[0] = items[size -= 1];
        items[size] = 0;

        bubbleDown();
        return root;
    }

    private void bubbleDown() {
        var index = 0;
        while (!isValidParent(index)) {
            var largestChildIndex = getLargestChildValue(index);
            swap(index, largestChildIndex);
            index = largestChildIndex;
        }
    }

    private int getLargestChildValue(int index) {
        return (leftChild(index) > rightChild(index))
                ? leftChildIndex(index)
                : rightChildIndex(index);
    }

    private boolean isValidParent(int index) {
        return items[index] >= leftChild(index) && items[index] >= rightChild(index);
    }

    private int leftChild(int index) {
        return items[leftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[rightChildIndex(index)];
    }

    private int leftChildIndex(int parentIndex) {
        return parentIndex * 2 + 1;
    }

    private int rightChildIndex(int parentIndex) {
        return parentIndex * 2 + 2;
    }

    private void bubbleUp() {
        var index = size - 1;
        while (index >= 0 && items[index] > items[parentIndex(index)]) {
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    public boolean isFull() {
        return size == items.length;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    private void swap(int first, int second) {
        var tmp = items[first];
        items[first] = items[second];
        items[second] = tmp;
    }

    private int parentIndex(int index) {
        return (index - 1) / 2;
    }


    @Override
    public String toString() {
        return Arrays.toString(items);
    }
}
