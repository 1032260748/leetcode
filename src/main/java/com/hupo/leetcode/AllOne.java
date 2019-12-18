package com.hupo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class AllOne {

    Map<String, LinkNode> map;

    LinkNode head;

    LinkNode tail;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        map = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        if (!map.containsKey(key)) {
            LinkNode linkNode = new LinkNode();
            linkNode.key = key;
            linkNode.value = 1;
            linkNode.pre = tail;

            if (tail != null) {
                tail.next = linkNode;
            }
            tail = linkNode;
            if (head == null) {
                head = tail;
            }
            map.put(key, linkNode);
        } else {
            LinkNode currentNode = map.get(key);
            currentNode.value = currentNode.value + 1;

            upShift(currentNode);
        }
    }


    public void upShift(LinkNode node) {
        if (node.pre == null) {
            head = node;
            return;
        }
        if (node.pre.value >= node.value) {
            return;
        }

        LinkNode pre = node.pre;
        LinkNode prePre = pre.pre;
        LinkNode next = node.next;

        //当前节点是尾节点
        pre.next = next;
        if (next == null) {
            tail = pre;
        } else {
            next.pre = pre;
        }
        pre.pre = node;
        node.next = pre;
        node.pre = prePre;
        if (prePre != null) {
            prePre.next = node;
        }

        upShift(node);
    }


    public void downShift(LinkNode node) {
        if (node.next == null) {
            tail = node;
            return;
        }
        if (node.next.value <= node.value) {
            return;
        }

        LinkNode next = node.next;
        LinkNode nextNext = next.next.next;
        LinkNode pre = node.pre;

        //当前节点是头节点
        next.pre = pre;
        if (pre == null) {
            head = next;
        } else {
            pre.next = next;
        }
        next.next = node;
        node.pre = next;
        node.next = nextNext;
        if (nextNext != null) {
            nextNext.pre = node;
        }

        downShift(node);
    }


    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        LinkNode currentNode = map.get(key);
        if (currentNode == null) {
            return;
        }
        //删除节点
        if (currentNode.value == 1) {
            map.remove(key);
            //如果是头节点
            if (head == currentNode) {
                if (currentNode.next != null) {
                    currentNode.next.pre = null;
                    head = currentNode.next;
                } else {
                    head = null;
                    tail = null;
                }
            } else if (tail == currentNode) {
                if (currentNode.pre != null) {
                    currentNode.pre.next = null;
                    tail = currentNode.pre;
                } else {
                    head = null;
                    tail = null;
                }
            } else {
                LinkNode pre = currentNode.pre;
                LinkNode next = currentNode.next;

                pre.next = next;
                next.pre = pre;
            }

            currentNode.pre = null;
            currentNode.next = null;
        } else {
            //移动节点
            currentNode.value = currentNode.value - 1;
            downShift(currentNode);
        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        if (head != null) {
            return head.key;
        } else {
            return "";
        }
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        if (tail != null) {
            return tail.key;
        } else {
            return "";
        }
    }


    public static class LinkNode {
        public String key;
        public Integer value;
        public LinkNode pre;
        public LinkNode next;
    }
}
