package com.hupo.leetcode.array;

public class Rob {

    public static void main(String[] args) {
        int[] array = new int[] { 2, 7, 9, 3, 1 };
        Rob rob = new Rob();
        int result = rob.rob(array);
        System.out.println(result);
    }

    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int a = 0;
        int b = 0;

        for (int i = 0; i <= nums.length - 1; i++) {
            if (a + nums[i] >= b) {
                int temp = a + nums[i];
                a = b;
                b = temp;
            } else {
                a = b;
            }
        }
        return b;
    }
}
