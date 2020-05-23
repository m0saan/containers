package com.moboustt;

public class Main {
    public static void main(String[] args) {
        var Array = new Array(10);
        Array.insert(1);
        Array.insert(3);
        Array.insert(5);
        Array.insert(4);
        Array.insert(9);
        Array.insert(13);
        Array.insert(7);

        Array.insertAt(99, 2);
        Array.print();
    }
}
