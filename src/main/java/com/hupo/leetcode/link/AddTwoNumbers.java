package com.hupo.leetcode.link;

import com.hupo.leetcode.ListNode;

import java.util.Stack;

public class AddTwoNumbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);


        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.println(listNode);
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }


        int flag = 0;

        ListNode newHead = new ListNode(-1);

        ListNode currentNode = newHead;

        while (l1 != null || l2 != null) {

            int temp1 = 0;
            if (l1 != null) {
                temp1 = l1.val;
                l1 = l1.next;
            }

            int temp2 = 0;
            if (l2 != null) {
                temp2 = l2.val;
                l2 = l2.next;
            }


            int result = temp1 + temp2 + flag;

            if (result >= 10) {
                flag = 1;
                result = result - 10;
            } else {
                flag = 0;
            }

            ListNode nextNode = new ListNode(result);
            currentNode.next = nextNode;

            currentNode = nextNode;
        }

        if (flag == 1) {
            ListNode nextNode = new ListNode(1);
            currentNode.next = nextNode;
        }

        return newHead.next;
    }


    private Stack<Integer> putToStack(ListNode listNode) {
        ListNode current = listNode;

        Stack<Integer> integers = new Stack<>();

        while (current != null) {
            integers.push(current.val);
            current = current.next;
        }

        return integers;

    }
}
