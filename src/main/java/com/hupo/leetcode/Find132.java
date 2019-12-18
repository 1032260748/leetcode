package com.hupo.leetcode;

import java.util.Stack;

public class Find132 {

    public boolean find132pattern(int[] nums) {

        if (nums == null || nums.length <= 2) {
            return false;
        }

        int third = Integer.MIN_VALUE;

        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < third && !stack.isEmpty()) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop();
            }
            stack.push(nums[i]);
        }

        return false;
    }
}
