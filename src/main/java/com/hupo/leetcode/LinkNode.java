package com.hupo.leetcode;


public class LinkNode<T> {

    public T val;

    public LinkNode<T> next;


    public static <T> LinkNode<T> lastN(LinkNode<T> head, int n) {

        if (head == null || n <= 0) {
            return null;
        }
        LinkNode<T> p1 = head;
        for (int i = 0; i < n - 1; i++) {
            if (p1.next != null) {
                p1 = p1.next;
            } else {
                return null;
            }
        }
        LinkNode<T> p2 = head;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;

    }


}
