package com.hupo.leetcode;

public class DeleteNodeSolution {

    private ListNode head;

    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;
    }
}
