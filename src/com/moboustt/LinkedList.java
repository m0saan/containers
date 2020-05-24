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
    private Node flag;

    // addFirst
    public void addFirst(int item) {
        var node = new Node(item);
        if (isEmpty())
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
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
        var current = first;
        int size = 0;
        while (current != null){
            current = current.next;
            size++;
        }
        return size;
    }
    // printList
    public void printList(){
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
