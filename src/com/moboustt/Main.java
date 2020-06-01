package com.moboustt;

import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        var tree = new Tree();
        tree.insert(7);
        tree.insert(9);
        tree.insert(4);
        tree.insert(1);
        tree.insert(6);
        tree.insert(10);
        tree.insert(8);

        tree.nodesAtKDistance(1);
    }

    public static void reversedQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty())
            stack.add(queue.remove());
        while (!stack.isEmpty())
            queue.add(stack.pop());
    }

    // Allowed : add() remove() isEmpty()
    public static void aPlusB() {
        Scanner scanner = new Scanner(System.in);
        int numberOfAdditions = scanner.nextInt();
        while (numberOfAdditions > 0) {
            String first = scanner.next();
            String second = scanner.next();
            int result = Integer.parseInt(first) + Integer.parseInt(second);
            System.out.println(result);
            numberOfAdditions--;
        }
    }

    public static void lastDigit() {
        var scanner = new Scanner(System.in);
        byte num = scanner.nextByte();
        while (num > 0) {
            byte n = scanner.nextByte();
            scanner.close();
            char[] result = Long.toString(factorial(n)).toCharArray();
            System.out.println(result[result.length - 1]);
            num--;
        }
    }

    public static long factorial(int n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
