package com.hupo.leetcode;

import java.util.Stack;

/**
 * miniStack
 */
public class MiniStack {

    private Stack<Integer> origin = new Stack<>();

    private Stack<Integer> mini = new Stack<>();

    public void push(int x) {
        origin.push(new Integer(x));
        if (mini.isEmpty()) {
            mini.push(new Integer(x));
        } else {
            int temp = mini.peek();
            if (temp <= x) {
                mini.push(temp);
            } else {
                mini.push(x);
            }
        }
    }

    public void pop() {
        origin.pop();
        mini.pop();
    }

    public int top() {
        return origin.peek();
    }

    public int getMin() {
        return mini.peek();
    }
}
