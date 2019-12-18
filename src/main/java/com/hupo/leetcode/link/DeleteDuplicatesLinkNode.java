package com.hupo.leetcode.link;

import com.hupo.leetcode.ListNode;

public class DeleteDuplicatesLinkNode {

    public static void main(String[] args) {
        ListNode x1 = new ListNode(1);
        ListNode x2 = new ListNode(2);
        ListNode x3 = new ListNode(2);

        x1.next = x2;
        x2.next = x3;

        DeleteDuplicatesLinkNode deleteDuplicatesLinkNode = new DeleteDuplicatesLinkNode();

        ListNode newHead = deleteDuplicatesLinkNode.deleteDuplicates(x1);
        System.out.println(newHead);

    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode newHead = new ListNode();
        ListNode newCurrent = newHead;

        ListNode pre = head;

        ListNode current = head.next;

        if (pre.val != current.val) {
            newCurrent.next = pre;
            newCurrent = pre;
            newCurrent.next = null;
        }

        while (current != null) {
            if (current.val != pre.val) {
                if (current.next == null || current.val != current.next.val) {
                    newCurrent.next = current;
                    newCurrent = current;
                }
            }

            pre = current;
            current = current.next;
            newCurrent.next = null;
        }
        return newHead.next;
    }
}
