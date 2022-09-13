package com.hupo.leetcode.array;

public class SearchInsert {

    public static void main(String[] args) {
        SearchInsert solution = new SearchInsert();
        int[] nums = new int[] { 1, 3 };
        int index = solution.searchInsertBig(nums, 2);
        System.out.println(index);

    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 || nums[nums.length - 1] >= nums[0]) {
            return searchInsertBig(nums, target);
        } else {
            return searchInsertSmall(nums, target);
        }
    }

    /**
     * from small to big
     *
     * @return
     */
    private int searchInsertBig(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (nums[left] >= target) {
            return left;
        } else {
            return left + 1;
        }
    }

    /**
     * from big to small
     *
     * @return
     */
    private int searchInsertSmall(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (nums[left] <= target) {
            return left;
        } else {
            return left + 1;
        }
    }
}
