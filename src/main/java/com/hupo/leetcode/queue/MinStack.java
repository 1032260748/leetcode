package com.hupo.leetcode.queue;

import java.util.Stack;

public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> min = new Stack<>();


    /**
     * initialize your data structure here.
     */
    public MinStack() {

    }

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty()) {
            min.push(x);
        } else {
            int top = min.peek();
            if (x < top) {
                min.push(x);
            } else {
                min.push(top);
            }
        }
    }

    public void pop() {
        stack.pop();
        min.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min.peek();
    }
}
