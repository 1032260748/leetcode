package com.hupo.leetcode.sort;

import com.hupo.leetcode.tree.MinDepth;

public class ArraySort {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 2, 7, 6, 1, 2, 13};
        new ArraySort().quickSort(arr);
        System.out.println(arr);
    }

    public void mergeSort(int[] arr) {

    }

    public void mergeSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);




    }

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int selectNum = arr[start];

        int left = start;
        int right = end;
        while (left < right) {

            while (arr[right] <= selectNum && right > left) {
                right--;
            }

            while (arr[left] > selectNum && left < right) {
                left++;
            }

            if (left < right) {
                swap(arr, right, left);
            }
        }

        quickSort(arr, start, right);
        quickSort(arr, right + 1, end);
    }


    public void bubbleSort(int[] array) {
        for (int i = 0; i <= array.length - 2; i++) {
            for (int j = array.length - 1; j >= i + 1; j--) {
                if (array[j] > array[j - 1]) {
                    swap(array, j, j - 1);
                }
            }
        }
    }

    public void selectSort(int[] array) {
        for (int i = 0; i <= array.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j <= array.length - 1; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                swap(array, maxIndex, i);
            }
        }
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}
