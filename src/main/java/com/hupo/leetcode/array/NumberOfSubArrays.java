package com.hupo.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

public class NumberOfSubArrays {

    public static void main(String[] args) {
        int[] array = new int[]{1, 1, 2, 1, 1};
        int result = numberOfSubarrays(array, 3);
        System.out.println(result);
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int result = 0;
        int preIndex = -1;

        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                if (deque.size() == k) {
                    int endLength = i - deque.getLast();
                    int startLength = deque.getFirst() - preIndex;
                    result = result + startLength * endLength;
                    preIndex = deque.getFirst();
                    deque.pollFirst();
                }
                deque.addLast(i);
            }

            if (i == nums.length - 1) {
                if (deque.size() == k) {
                    int endLength = i - deque.getLast() + 1;
                    int startLength = deque.getFirst() - preIndex;
                    result = result + startLength * endLength;
                }
            }
        }
        return result;
    }
}
