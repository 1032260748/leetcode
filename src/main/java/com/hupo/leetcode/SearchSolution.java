package com.hupo.leetcode;

public class SearchSolution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            if (nums[mid] > target) {
                if (nums[left] == target) {
                    return left;
                } else if (nums[left] < target) {
                    right = mid - 1;
                } else if (nums[left] > target) {
                    if (nums[mid] >= nums[left]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            } else if (nums[mid] < target) {
                if (nums[right] == target) {
                    return right;
                } else if (nums[right] > target || nums[mid] >= nums[left]) {
                    left = mid + 1;
                } else if (nums[mid] < nums[left]) {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
