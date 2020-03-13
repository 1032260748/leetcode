package com.hupo.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack {


    public Queue<Integer> queue = new LinkedList<>();
    public Queue<Integer> temp = new LinkedList<>();


    /**
     * Initialize your data structure here.
     */
    public MyStack() {

    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        if (queue.isEmpty()) {
            queue.offer(x);
        } else {
            while (!queue.isEmpty()) {
                temp.offer(queue.poll());
            }

            queue.offer(x);

            while (!temp.isEmpty()) {
                queue.offer(temp.poll());
            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        return queue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        return queue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}
