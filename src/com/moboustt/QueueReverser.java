package com.moboustt;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {
    public void reverse(Queue<Integer> queue,  int k){
        Stack<Integer> stack = new Stack<>();
        while(k-- > 0)
            stack.push(queue.remove());
        var size = queue.size();
        while (!stack.isEmpty())
            queue.add(stack.pop());
        while (size-- > 0)
            queue.add(queue.remove());
    }
}
