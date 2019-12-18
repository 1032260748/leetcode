package com.hupo.leetcode.link;


import java.math.BigDecimal;
import java.text.NumberFormat;

public class DlinkSort {

    public DlinkNode sort(DlinkNode<Integer> head, DlinkNode<Integer> tail) {
        DlinkNode<Integer> currentHead = head;

        DlinkNode<Integer> newHead = new DlinkNode<>(null);
        newHead.next = currentHead;

        while (currentHead != null && currentHead.next != null) {

            int max = currentHead.val;
            DlinkNode<Integer> maxNode = null;

            DlinkNode<Integer> temp = currentHead.next;
            while (temp != null) {
                if (temp.val > max) {
                    maxNode = temp;
                    max = maxNode.val;
                }
                temp = temp.next;
            }

            if (maxNode != null) {
                Integer swap = currentHead.val;
                currentHead.val = maxNode.val;
                maxNode.val = swap;
            }
            currentHead = currentHead.next;
        }
        return head;
    }


    public DlinkNode modifySort(DlinkNode<Integer> head, DlinkNode<Integer> tail) {
        DlinkNode<Integer> currentHead = head;

        DlinkNode<Integer> newHead = new DlinkNode<>(null);
        newHead.next = currentHead;
        currentHead.pre = newHead;

        while (currentHead != null && currentHead.next != null) {

            int max = currentHead.val;
            DlinkNode<Integer> maxNode = null;

            DlinkNode<Integer> temp = currentHead.next;
            while (temp != null) {
                if (temp.val > max) {
                    maxNode = temp;
                    max = maxNode.val;
                }
                temp = temp.next;
            }

            if (maxNode != null) {

                DlinkNode<Integer> currentPre = currentHead.pre;
                DlinkNode<Integer> maxPre = maxNode.pre;

                DlinkNode<Integer> currentNext = currentHead.next;
                DlinkNode<Integer> maxNext = maxNode.next;

                currentHead.next = maxNext;
                currentHead.pre = maxPre;
                maxPre.next = currentHead;
                if (maxNext != null) {
                    maxNext.pre = currentHead;
                }

                maxNode.next = currentNext;
                currentNext.pre = maxNode;
                currentPre.next = maxNode;
                maxNode.pre = currentPre;


                currentHead = maxNode;

            }
            currentHead = currentHead.next;
        }
        return newHead.next;
    }


    public static void main(String[] args) throws Exception {

        NumberFormat nf = NumberFormat.getPercentInstance();
        Number number = nf.parse("4.4%");
        System.out.println(new BigDecimal(number.doubleValue()).toString());

    }


}
