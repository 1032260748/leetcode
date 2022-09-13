package com.hupo.leetcode.tree;

import com.hupo.leetcode.ListNode;


public class RecoverTreeSolution {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        //获取长度
        int length = getLength(head);
        k = k % length;
        if (k == 0) {
            return head;
        }

        int move = length - k;
        ListNode moveNode = move(head, move);

        ListNode newHead = moveNode.next;
        moveNode.next = null;

        moveNode = move(newHead, k);
        moveNode.next = head;
        return newHead;
    }

    public static int getLength(ListNode node) {
        ListNode temp = node;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static ListNode move(ListNode head, int moveCount) {
        ListNode moveTo = head;
        int tempCount = 1;
        while (tempCount < moveCount) {
            moveTo = moveTo.next;
            tempCount++;
        }
        return moveTo;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(0);
        ListNode se = new ListNode(1);
        ListNode th = new ListNode(2);
        first.next = se;
        se.next = th;

        ListNode listNode;
        RecoverTreeSolution solution = new RecoverTreeSolution();

        //        listNode = solution.rotateRight(first, 0);
        //        print(listNode);
        //
        //        listNode = solution.rotateRight(first, 1);
        //        print(listNode);

        listNode = solution.rotateRight(first, 2);
        print(listNode);

    }

    public static void print(ListNode listNode) {
        ListNode temp = listNode;
        while (temp != null) {
            System.out.print(temp.val + ", ");
        }
        System.out.println();
    }

}
