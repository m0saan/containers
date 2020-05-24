package com.moboustt;

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
        while (first != null){
            if (first.next.next == null) {
                prevNode = first;
                last = prevNode;
                last.next = null;
            }
            first = first.next;
        }
        first = current;
    }
    // printList
    public void printList(){
        while (first != null) {
            System.out.println(first.value);
            first = first.next;
        }
    }
    private boolean isEmpty() {
        return first == null;
    }
}
