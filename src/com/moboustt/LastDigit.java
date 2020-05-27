package com.moboustt;

import java.util.Scanner;

public class LastDigit {
    public static void main(String[] args) {
    }
    public static void lastDigit(){
        var scanner = new Scanner(System.in);
        byte num = scanner.nextByte();
        while (num > 0){
            int n = scanner.nextInt();
            char[] result = Integer.toString(factorial(n)).toCharArray();
            System.out.println(result[result.length]);
            num--;
        }
    }

    public static int factorial(int n){
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }
}


/*
def lastDigit():
    num = int(input())
    while num:
        inpt = int(input())
        print(str(factorial(inpt))[-1])
        num -= 1


def factorial(n: int) -> int:
    if n == 0:
        return 1
    return n * factorial(n - 1)
 */