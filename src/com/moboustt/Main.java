package com.moboustt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var stackList = new LinkedListStack();
        stackList.push(10);
        stackList.push(20);
        stackList.push(30);

        stackList.pop();
        System.out.println(stackList.peek());
        System.out.println(stackList.isEmpty());
        System.out.println(stackList);
    }
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
        public static void lastDigit(){
        var scanner = new Scanner(System.in);
        byte num = scanner.nextByte();
        while (num > 0){
            byte n = scanner.nextByte();
            scanner.close();
            char[] result = Long.toString(factorial(n)).toCharArray();
            System.out.println(result[result.length - 1]);
            num--;
        }
    }
    public static long factorial(int n){
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}
