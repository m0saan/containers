package com.moboustt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var twoStacks = new TwoStacks(10);
        twoStacks.push1(10);
        twoStacks.push1(20);
        twoStacks.push2(100);
        twoStacks.push2(90);
        System.out.println(twoStacks);
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
