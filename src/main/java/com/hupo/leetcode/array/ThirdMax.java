package com.hupo.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class ThirdMax {
    public static void main(String[] args) {
        ThirdMax thirdMax = new ThirdMax();
        int result = thirdMax.thirdMax(new int[]{3, 3, 3, 3, 4, 3, 2, 3, 3});
        System.out.println(result);
    }

    public int thirdMax(int[] nums) {
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (deque.isEmpty()) {
                deque.addFirst(nums[i]);
            } else {
                if (nums[i] > deque.peekFirst()) {
                    deque.addFirst(nums[i]);
                    if (deque.size() > 3) {
                        deque.pollLast();
                    }
                } else if (nums[i] < deque.peekLast()) {
                    if (deque.size() < 3) {
                        deque.addLast(nums[i]);
                    }
                } else if (nums[i] < deque.peekFirst() && nums[i] > deque.peekLast()) {
                    Stack<Integer> stack = new Stack<>();
                    while (deque.peekLast() < nums[i]) {
                        stack.push(deque.pollLast());
                    }
                    deque.addLast(nums[i]);

                    while (deque.size() < 3 && !stack.isEmpty()) {
                        deque.addLast(stack.pop());
                    }
                    stack.clear();
                }
            }
        }

        if (deque.size() == 3) {
            return deque.peekLast();
        }
        return deque.peekFirst();
    }

}
