package com.hupo.leetcode.link;

public class ListNode {

    int val;
    ListNode next, random;

    ListNode(int x) {
        this.val = x;
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode current = head;
        int count = 0;
        while (current != null) {
            count++;
            current = current.next;
        }

        if (k > count) {
            return null;
        }

        int leftCount = count + 1 - k;

        int temp = 0;
        current = head;
        while (current != null && temp < leftCount-1) {
            temp++;
            current = current.next;
        }
        return current;
    }
}
