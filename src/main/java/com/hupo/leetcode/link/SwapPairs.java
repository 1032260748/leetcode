package com.hupo.leetcode.link;


public class SwapPairs {
    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode listNode = swapPairs.reverseBetween(head, 2, 3);
        System.out.println(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode newHead = new ListNode(-1);
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            current.next = null;
            current.next = newHead.next;
            newHead.next = current;
            current = next;
        }

        ListNode result = newHead.next;
        newHead.next = null;
        return result;
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode startNode = head;
        ListNode previous = null;
        int i = 1;
        while (i < m) {
            previous = startNode;
            startNode = startNode.next;
            i++;
        }

        ListNode newStartHead = new ListNode(-1);
        ListNode current = startNode;
        while (i <= n) {
            ListNode next = current.next;
            current.next = null;
            current.next = newStartHead.next;
            newStartHead.next = current;
            current = next;
            i++;
        }

        startNode.next = current;

        if (previous != null) {
            previous.next = newStartHead.next;
            newStartHead.next = null;
            return head;
        } else {
            ListNode realHead = newStartHead.next;
            newStartHead.next = null;
            return realHead;
        }
    }
}
