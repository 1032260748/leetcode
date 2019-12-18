package com.hupo.leetcode;


import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, ListNode<Integer>> map;

    private ListNode<Integer> head;

    private ListNode<Integer> tail;

    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    public int get(int key) {
        ListNode<Integer> node = getListNode(key);
        if (node == null) {
            return -1;
        } else {
            return node.value;
        }
    }

    public ListNode<Integer> getListNode(int key) {
        ListNode<Integer> node = map.get(key);
        if (node == null) {
            return null;
        } else if (node == head) {
            return node;
        } else {
            ListNode<Integer> preNode = node.pre;
            ListNode<Integer> nextNode = node.next;
            if (preNode != null) {
                preNode.next = nextNode;
            }
            if (nextNode != null) {
                nextNode.pre = preNode;
            } else {
                tail = node.pre;
            }

            node.pre = null;
            node.next = head;
            head.pre = node;

            head = node;

            if (tail == null) {
                tail = head;
            }

            return node;
        }
    }

    public void put(int key, int value) {
        ListNode<Integer> node = getListNode(key);
        if (node != null) {
            node.value = value;
        } else {
            if (map.size() < this.capacity) {
                insertHead(key, value);
            } else {
                removeTail();
                insertHead(key, value);
            }
        }
    }

    public void insertHead(int key, int value) {
        ListNode<Integer> current = new ListNode<>();
        current.value = value;
        current.key = key;
        current.next = head;

        if (head != null) {
            head.pre = current;
        }
        head = current;

        if (tail != null) {
            if (tail.pre == null) {
                tail.pre = current;
            }
        }

        if (current.next == null) {
            tail = current;
        }

        map.put(key, current);
    }


    public void removeTail() {
        map.remove(tail.key);
        ListNode<Integer> pre = tail.pre;
        if (pre == null) {
            head = tail = null;
        } else {
            tail = pre;
            pre.next = null;
            if (pre.pre == null) {
                head = pre;
            }
        }
    }


    public static class ListNode<T> {
        public T value;
        public T key;
        public ListNode<T> next;
        public ListNode<T> pre;

        @Override
        public boolean equals(Object object) {
            if (object == null) {
                return false;
            }
            if (!object.getClass().isAssignableFrom(this.getClass())) {
                return false;
            }

            ListNode<T> temp = (ListNode<T>) object;
            return this.key.equals(temp.key);
        }
    }


}
