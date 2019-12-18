package com.hupo.leetcode.link;


import java.util.HashMap;
import java.util.Map;

public class RandomLinkCopy {
    public ListNode copyRandomList(ListNode head) {
        if (head == null) {
            return null;
        }

        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode current = head;
        while (current != null) {
            ListNode newCurrent = new ListNode(current.val);
            map.put(current, newCurrent);
            current=current.next;
        }

        for (Map.Entry<ListNode, ListNode> entry : map.entrySet()) {
            ListNode originNode = entry.getKey();
            ListNode newNode = entry.getValue();

            if (originNode.next != null) {
                newNode.next = map.get(originNode.next);
            }
            if (originNode.random != null) {
                newNode.random = map.get(originNode.random);
            }
        }

        return map.get(head);
    }
}
