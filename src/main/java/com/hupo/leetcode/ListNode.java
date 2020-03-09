package com.hupo.leetcode;


import java.util.*;

public class ListNode {

    public int val;

    public ListNode next;

    public ListNode() {

    }

    public ListNode(int x) {
        val = x;
        next = null;

    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head.next;
        ListNode pre = head;
        pre.next = null;
        while (current != null) {
            ListNode next = current.next;
            if (current.val != pre.val) {
                pre.next = current;
                pre = current;
                pre.next = null;
            }
            current = next;
        }

        return head;
    }

    public ListNode deleteDuplicates2(ListNode head) {

        return null;

    }


    public ListNode removeElements(ListNode head, int val) {
        ListNode newHead = new ListNode(-1);

        ListNode validBefore = newHead;

        ListNode current = head;
        while (current != null) {
            if (current.val != val) {
                validBefore.next = current;
                validBefore = current;
            }
            current = current.next;
            validBefore.next = null;
        }

        return newHead.next;
    }


    public String getPermutation(int n, int k) {

        return null;

    }


    private void nextList(int[] list) {
        int findIndex = -1;

        for (int i = list.length - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (list[i] > list[j]) {
                    findIndex = i;
                    break;
                }
            }
            if (findIndex > -1) {
                break;
            }
        }

        if (findIndex == 1) {
            return;
        }
    }

    public String combine(int[] list) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i <= list.length - 1; i++) {
            builder.append(list[i]);
        }
        return builder.toString();
    }

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int one = 1;
        int two = 2;

        for (int i = 3; i <= n; i++) {
            int current = one + two;
            one = two;
            two = current;
        }

        return two;
    }


    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        map.put(nums[0], 0);

        for (int i = 1; i <= nums.length - 1; i++) {

            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }

        return null;

    }

    public String dayOfTheWeek(int day, int month, int year) {
        String[] week = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};


        return null;

    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination) {

        int one = 0;
        int current = start;
        while (current != destination) {
            one = one + distance[current];
            current = (current + 1) % distance.length;
        }

        int two = 0;

        current = start;
        while (current != destination) {
            int next = (distance.length - 1 + current) % distance.length;
            two = two + distance[next];
            current = next;
        }

        return Math.max(one, two);
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr));
    }


    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= arr.length - 1; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }


        Set<Integer> set = new HashSet<>();
        for (Integer value : map.values()) {
            if (set.contains(value)) {
                return false;
            } else {
                set.add(value);
            }
        }
        return true;

    }


}
