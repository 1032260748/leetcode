package com.hupo.leetcode;


import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.Stack;

public class AsteroidCollision {

    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode m = new ListNode();
        ListNode n = new ListNode();

        ListNode mCur = m;
        ListNode nCur = n;

        int i = 1;
        ListNode cur = head;
        while (cur != null) {

            if (i % 2 == 1) {
                mCur.next = cur;
                mCur = cur;
            } else {
                nCur.next = cur;
                nCur = cur;
            }

            ListNode temp = cur;
            cur = cur.next;

            temp.next = null;

            i++;
        }

        mCur.next = n.next;
        n.next = null;

        ListNode newHead = m.next;
        m.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode first = new ListNode(1);
        first.next = new ListNode(2);
        first.next.next = new ListNode(3);
        first.next.next.next = new ListNode(4);
        first.next.next.next.next = new ListNode(5);
        ListNode listNode = oddEvenList(first);
        System.out.println(listNode);

    }


    public int[] asteroidCollision(int[] asteroids) {

        if (asteroids == null || asteroids.length == 0) {
            return new int[0];
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= asteroids.length - 1; i++) {
            int current = asteroids[i];
            handleCrash(stack, current);
        }

        int[] result = new int[stack.size()];

        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }

    /**
     * 处理碰撞
     *
     * @param stack
     * @param current
     */
    public void handleCrash(Stack<Integer> stack, Integer current) {

        if (current > 0) {
            stack.push(current);
            return;
        }

        if (stack.isEmpty()) {
            stack.push(current);
            return;
        }

        Integer top = stack.peek();
        if (top < 0) {
            stack.push(current);
            return;
        }

        if (top == Math.abs(current)) {
            //发生碰撞，两个都消失
            stack.pop();
        } else if (Math.abs(top) > Math.abs(current)) {
            //发生碰撞，保留正值
            return;
        } else {
            //发生碰撞，并且保留 负值
            stack.pop();
            handleCrash(stack, current);
        }

    }


}
