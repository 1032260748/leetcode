package com.hupo.leetcode.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class MaxQueue {

    private Queue<Integer> queue = new LinkedList<>();
    private Deque<Integer> maxQueue = new LinkedList<>();

    public MaxQueue() {

    }

    public int max_value() {
        if (maxQueue.isEmpty()) {
            return -1;
        }
        return maxQueue.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
            maxQueue.removeLast();
        }
        maxQueue.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        int first = queue.peek();
        if (first == maxQueue.peekFirst()) {
            maxQueue.removeFirst();
        }
        return queue.poll();
    }
}
