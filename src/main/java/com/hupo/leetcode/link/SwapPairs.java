package com.hupo.leetcode.link;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SwapPairs {
    public static void main(String[] args) {
        SwapPairs swapPairs = new SwapPairs();
        int[] nums = new int[]{3, 4};
        swapPairs.swapNumbers(nums);
        System.out.println(nums);

        ExecutorService pool = Executors.newFixedThreadPool(2);

        pool.submit(new Runnable() {
            @Override
            public void run() {

            }
        });
    }


    public ListNode swapPairsTwo(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode next = head.next.next;
        head.next.next = null;

        ListNode newHead = head.next;
        head.next = null;
        newHead.next = head;
        head.next = swapPairs(next);

        return newHead;
    }

    public int[] swapNumbers(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return numbers;
        }
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
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
