package com.moboustt;

public class Main {
    public static void main(String[] args) {
        var list = new LinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.deleteLast();
        list.deleteLast();
        list.deleteLast();
        //list.printList();
        System.out.println("Done!");
    }
}
