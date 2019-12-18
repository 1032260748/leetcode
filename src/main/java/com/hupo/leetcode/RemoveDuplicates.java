package com.hupo.leetcode;


public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int length = nums.length;
        int last = nums[0];
        int flag = 1;
        for (int i = 1; i <= length - 1; i++) {
            int current = nums[i];
            if (current == last) {
                if (flag == 1) {
                    flag = 2;
                } else if (flag == 2) {
                    move(nums, i, length);
                    i--;
                    length = length - 1;
                }
            } else {
                last = current;
                flag = 1;
            }
        }

        return length;
    }

    private void move(int[] nums, int start, int length) {
        for (int i = start; i <= length - 2; i++) {
            nums[i] = nums[i + 1];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{
                0, 0, 1, 1, 1, 1, 2, 3, 3
        };

        RemoveDuplicates removeDuplicates = new RemoveDuplicates();
        int length = removeDuplicates.removeDuplicates(nums);
        System.out.println(length);

    }
}
