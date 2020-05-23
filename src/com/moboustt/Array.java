package com.moboustt;

import java.util.ArrayList;

public class Array {
    private int[] array;
    private int count = 0;

    public Array(int length) {
        array = new int[length];
    }

    public void print() {
        // O(n)
        for (int i = 0; i < count; i++)
            System.out.println(array[i]);
    }

    public void insert(int item){
        if (count == array.length){
            int[] anotherArray = new int[count + 1];
            // O(n)
            for (int i = 0; i < count ; i++)
                anotherArray[i] = array[i];
            array = anotherArray;
        }
        array[count++] = item;
    }

    public void remove(int index){
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        // O(n)
        for (int i = index; i < count; i++)
            array[i] = array[i+1];
        count--;
    }

    public int indexOf(int item){
        // O(n)
        for (int i = 0; i < count; i++) {
            if (item == array[i])
                return i;
        }
        return -1;
    }

    public int max(){
        int largestNumber = 0;
        // O(n)
        for (int i = 0; i < count; i++) {
            if (array[i] > largestNumber)
                largestNumber = array[i];
        }
        return largestNumber;
    }

    public void intersect(int[] another){
        // O(n^2)
        for (int i = 0; i < count ; i++) {
            for (int j = 0; j < another.length ; j++) {
                if(array[i] == another[j])
                    System.out.println(array[i]);
            }
        }
    }

    public ArrayList<Integer> reverse(){
        // O(n)
        ArrayList <Integer> reversed = new ArrayList<>();
        for (int i = count - 1; i >= 0 ; i--) {
            reversed.add(array[i]);
        }
        return reversed;
    }

    public void insertAt(int item, int index){
        // O(n)
        insert(item);
        for (int i = count; i > index; i--)
            array[i] = array[i - 1];
        array[index] = item;
    }
}
