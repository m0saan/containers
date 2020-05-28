package com.moboustt;

import java.util.Arrays;
import java.util.Stack;

public class Str {

    public String strReverse(String str) {
        if (str == null) throw new IllegalArgumentException();
        Stack<Character> stack = new Stack< >();
        for (char c:str.toCharArray())
            stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!(stack.empty()))
            reversed.append(stack.pop());
        return reversed.toString();
    }

    public boolean isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (isLeft(c))
                stack.push(c);

            if (isRight(c)){
                if (stack.empty()) return false;
                    var current = stack.pop();
                if (!isLeftAndRightMatch(c, current)) return false;
            }
        }
        return stack.empty();
    }

    private boolean isLeft(char c){
        var list = Arrays.asList('(','{','<','[');
        return list.contains(c);
    }

    private boolean isRight(char c){
        return Arrays.asList(')','}','>',']').contains(c);
    }

    private boolean isLeftAndRightMatch(char c, char current){
        return c - current <= 2 && c - current > 0;
    }
}
