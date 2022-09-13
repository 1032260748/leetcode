package com.hupo.leetcode.link;

import java.util.Stack;

public class GetIntersectionNode {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> stackA = getStack(headA);
        Stack<ListNode> stackB = getStack(headB);

        ListNode result = null;
        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (stackA.peek() == stackB.peek()) {
                result = stackA.peek();
                stackA.pop();
                stackB.pop();
            } else {
                break;
            }
        }
        return result;
    }

    public Stack<ListNode> getStack(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode current = head;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        return stack;
    }

    public ListNode getLast(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        return current;
    }

}
