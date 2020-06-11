package com.moboustt;

import java.util.Arrays;

public class MinHeap {
    private static class Node{
        private int key;
        private String value;

        public Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node[] nodes;
    private int capacity;
    private int size = 0;
    private String min;

    public MinHeap(int capacity){
        this.capacity = capacity;
        nodes = new Node[capacity];
    }

    public void insert(int key, String value){
        var node = new Node(key, value);

        nodes[size++] = node;

        bubbleUp(key);
    }

    public void remove(){
        min = nodes[0].value;
        nodes[0] = nodes[--size];
        nodes[size] = null;

        bubbleDown();
    }

    private void bubbleDown() {
        var index = 0;
        while(!isValidParent(index)){
            var minChildKeyIndex = getLargerKeyIndex(index);
            swap(index, minChildKeyIndex);
            index = minChildKeyIndex;

        }
    }

    private void bubbleUp(int key) {
        var index = size - 1;
        var parent = parentIndex(index);
        while (key < nodes[parentIndex(index)].key){
            swap(index, parentIndex(index));
            index = parentIndex(index);
        }
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    private void swap(int first, int second){
        var temp = nodes[first];
        nodes[first] = nodes[second];
        nodes[second] = temp;
    }

    private int parentIndex(int index){
        return (index - 1) / 2;
    }

    private int leftChildIndex(int index){
        return index * 2 + 1;
    }

    private int rightChildIndex(int index){
        return index * 2 + 2;
    }

    private Node leftChild(int index){
        return nodes[index];
    }

    private Node rightChild(int index){
        return nodes[index];
    }

    private boolean isValidParent(int index){
        var right = rightChildIndex(index);
        var left = leftChildIndex(index);
        if (left < size && right < size)
            return nodes[index].key <= nodes[left].key && nodes[index].key <= nodes[right].key;
        return true;
    }

    private int getLargerKeyIndex(int index){
        return leftChild(index).key > rightChild(index).key ? rightChildIndex(index) : leftChildIndex(index);
    }
}
