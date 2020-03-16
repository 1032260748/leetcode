package com.hupo.leetcode.array;

public class Exchange {

    public static void main(String[] args) {
        Exchange exchange = new Exchange();

        int[] array = new int[]{1, 2, 4, 3, 6, 7};
        exchange.exchange(array);
        System.out.println(array);
    }

    public int[] exchange(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left < right) {

            while (left < right && nums[left] % 2 == 1) {
                left++;
            }
            while (left < right && nums[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                swap(nums, left, right);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int m, int n) {
        int temp = nums[m];
        nums[m] = nums[n];
        nums[n] = temp;
    }

}
