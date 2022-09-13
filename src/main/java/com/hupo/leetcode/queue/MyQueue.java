package com.hupo.leetcode.queue;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stackA = new Stack<>();

    private Stack<Integer> stackB = new Stack<>();

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {

    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        stackA.push(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        if (!stackB.isEmpty()) {
            return stackB.pop();
        }
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
        if (!stackB.isEmpty()) {
            return stackB.pop();
        }
        return -1;
    }

    /**
     * Get the front element.
     */
    public int peek() {
        if (!stackB.isEmpty()) {
            return stackB.peek();
        }
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
        return stackB.peek();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return stackB.isEmpty() && stackA.isEmpty();
    }
}
