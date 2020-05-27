package com.moboustt;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class LinkedList {

    private static class Node {
        private final int value;
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

    public int popFirst(){
        if (isEmpty()) throw new NoSuchElementException();
        size--;
        int ret;
        if (first == last){
            ret = first.value;
            first = last = null;
            return ret;
        }
        var second = first.next;
        ret = first.value;
        first.next = null;
        first = second;
        return ret;
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

    // hasLoop()
    // O(n)
    // [1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8]
    //                 *                   *
    public boolean hasLoop(){
        var slow = first;
        var fast = first;
        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) return true;
        }
        return false;
    }

    public void createFloydCycle(int l){
        var current = first;
        var referee = first;
        while (current != null){
            if (l == 0) referee = current;
            current = current.next;
            l--;
        }
        last.next = referee;
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
    public ArrayList<Integer> printList(){
        ArrayList<Integer> list = new ArrayList<>();
        var current = first;
        while (current != null) {
            list.add(current.value);
            current = current.next;
        }
        return list;
    }
    private boolean isEmpty() {
        return first == null;
    }

    public int getFirst() {
        return first.value;
    }
}
