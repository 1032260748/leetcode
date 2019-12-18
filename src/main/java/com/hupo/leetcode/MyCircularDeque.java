package com.hupo.leetcode;


public class MyCircularDeque {

    private int capacity;

    private DequeueNode first;

    private DequeueNode last;

    private int currentSize = 0;

    /**
     * Initialize your data structure here. Set the size of the deque to be k.
     */
    public MyCircularDeque(int k) {
        this.capacity = k;
        this.currentSize = 0;
    }

    /**
     * Adds an item at the front of Deque. Return true if the operation is successful.
     */
    public boolean insertFront(int value) {

        if (this.currentSize == capacity) {
            return false;
        }

        DequeueNode dequeueNode = new DequeueNode();
        dequeueNode.val = value;

        if (this.currentSize == 0) {
            this.first = dequeueNode;
            this.last = dequeueNode;
        } else {
            this.first.pre = dequeueNode;
            dequeueNode.next = this.first;
            this.first = dequeueNode;
        }
        this.currentSize++;

        return true;
    }

    /**
     * Adds an item at the rear of Deque. Return true if the operation is successful.
     */
    public boolean insertLast(int value) {
        if (this.currentSize == capacity) {
            return false;
        }

        DequeueNode dequeueNode = new DequeueNode();
        dequeueNode.val = value;

        if (this.currentSize == 0) {
            this.first = dequeueNode;
            this.last = dequeueNode;
        } else {
            this.last.next = dequeueNode;
            dequeueNode.pre = this.last;
            this.last = dequeueNode;
        }
        this.currentSize++;

        return true;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is successful.
     */
    public boolean deleteFront() {
        if (this.currentSize == 0) {
            return false;
        }
        if (this.currentSize == 1) {
            this.first = null;
            this.last = null;
        } else {
            DequeueNode next = this.first.next;
            next.pre = null;
            this.first.next = null;
            this.first = next;
        }

        this.currentSize--;
        return true;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is successful.
     */
    public boolean deleteLast() {

        if (this.currentSize == 0) {
            return false;
        }
        if (this.currentSize == 1) {
            this.first = null;
            this.last = null;
        } else {
            DequeueNode pre = last.pre;
            pre.next = null;
            last.pre = null;
            last = pre;
        }

        this.currentSize--;
        return true;
    }

    /**
     * Get the front item from the deque.
     */
    public int getFront() {
        if (first == null) {
            return -1;
        }
        return first.val;
    }

    /**
     * Get the last item from the deque.
     */
    public int getRear() {
        if (last == null) {
            return -1;
        }
        return last.val;
    }

    /**
     * Checks whether the circular deque is empty or not.
     */
    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    /**
     * Checks whether the circular deque is full or not.
     */
    public boolean isFull() {
        return this.currentSize == this.capacity;
    }

    public static class DequeueNode {
        public int val;

        public DequeueNode pre;

        public DequeueNode next;
    }

}
