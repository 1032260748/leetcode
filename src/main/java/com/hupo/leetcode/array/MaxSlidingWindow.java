package com.hupo.leetcode.array;

import java.util.PriorityQueue;

public class MaxSlidingWindow {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        int result[] = maxSlidingWindow(nums, 3);
        System.out.println(result);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        int[] result = new int[nums.length - k + 1];
        int index = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2) * -1);
        for (int i = 0; i < nums.length; i++) {
            if (queue.size() < k - 1) {
                queue.offer(nums[i]);
            } else {
                queue.offer(nums[i]);
                result[index++] = queue.peek();
                queue.remove(nums[i - k + 1]);
            }
        }
        return result;
    }
}
