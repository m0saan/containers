package com.moboustt;

import java.io.BufferedReader;
import java.util.NoSuchElementException;

public class LinkedList {

    private class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    private Node first;
    private Node last;
    private int size;

    // addFirst
    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
        size++;
    }
    // addLast
    public void addLast(int item){
        var node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
        size++;
    }

    // contains
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    // indexOf
    public int indexOf(int item){
        var current = first;
        for (int i = 0; current != null ; i++) {
            if (current.value == item)
                return i;
            current = current.next;
        }
        return -1;
    }
    // deleteFirst
    public void deleteFirst(){
        if (isEmpty())
            throw new NoSuchElementException();
        size--;
        if (first == last){
            first = last = null;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
    }
    // deleteLast
    public void deleteLast(){
        if (isEmpty())
            throw new NoSuchElementException();
        size--;
        if (last == first){
            first = last = null;
            return;
        }
        var current = first;
        var prevNode = first;
        while (current != null){
            if (current.next.next == null) {
                prevNode = current;
                last = prevNode;
                last.next = null;
            }
            current = current.next;
        }
    }
    
    public int size(){
        return size;
    }

    public void reverse(){
        if (isEmpty()) return;
        Node previousNode = null;
        var currentNode = first;
        var nextNode = first.next;
        while (currentNode != null){
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
            if (nextNode != null)
                nextNode = nextNode.next;
        }

        last = first;
        first = previousNode;
    }

    public int getKthFromTheEnd1(int k){
        if (k <= 0 || isEmpty()) return -1;
        int flag = size - k;
        while (flag > 0){
            first = first.next;
            flag--;
        }
        return first.value;
    }

    public int getKthFromTheEnd2(int k){
        if (isEmpty() || k <= 0) return -1;
        var firstRef = first;
        var secondRef = first;
        int flag = 0;
        while (firstRef != null){
            if (flag > k-1)
                secondRef = secondRef.next;
            firstRef = firstRef.next;
            flag++;
        }
        return secondRef.value;
    }

    public int[] toArray(){
        var current = first;
        int[] arrayInts = new int[size];
        int index = 0;
        while (current != null){
            arrayInts[index] = current.value;
            current = current.next;
            index++;
        }
        return arrayInts;
    }
    public void printList( ){
        var current = first;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }
    private boolean isEmpty() {
        return first == null;
    }
}
