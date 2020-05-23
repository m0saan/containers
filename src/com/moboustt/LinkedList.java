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
    public boolean contains(int item){
        while (first != null){
            if (first.value == item)
                return true;
            first = first.next;
        }
        return false;
    }

    // indexOf
    public int indexOf(int item){
        for (int i = 0; first != null ; i++) {
            if (first.value == item)
                return i;
            first = first.next;
        }
        return -1;
    }
    // deleteFirst
    public void deleteFirst(){

    }
    // deleteLast
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
