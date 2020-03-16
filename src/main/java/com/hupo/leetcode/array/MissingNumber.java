package com.hupo.leetcode.array;


public class MissingNumber {

    public static void main(String[] args) {
        MissingNumber missingNumber = new MissingNumber();
        int[] array = new int[]{0, 2, 3};
        int result = missingNumber.missingNumber(array);
        System.out.println(result);
    }

    public int missingNumber(int[] nums) {
        if (nums[0] > 0) {
            return 0;
        }
        if (nums[nums.length - 1] < nums.length) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (nums[mid] - nums[left] > mid - left) {
                right = mid;
            } else if (nums[right] - nums[mid] > right - mid) {
                left = mid;
            }
            if (left + 1 == right && nums[right] - nums[left] > 1) {
                return nums[left] + 1;
            }
        }
        return nums[left] + 1;
    }
}
