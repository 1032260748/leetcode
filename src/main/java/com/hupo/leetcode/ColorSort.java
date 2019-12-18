package com.hupo.leetcode;

/**
 * 三路快速排序
 */
public class ColorSort {

    public void sortColors(int[] nums) {
        int start = -1;
        int end = nums.length;

        for (int i = 0; i < end; ) {
            if (nums[i] == 0) {
                swap(nums, ++start, i++);
            } else if (nums[i] == 2) {
                swap(nums, --end, i);
            } else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        ColorSort colorSort = new ColorSort();

        int[] array = new int[]{0, 1, 0, 2, 0, 2, 1, 0, 2, 1, 0};
        colorSort.sortColors(array);
        System.out.println(array);
    }


    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

}
