package com.hupo.leetcode.array;

public class XorQueries {

    public static void main(String[] args) {
        System.out.println(-10 >>> 1);
    }

    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] xorArray = new int[arr.length];
        xorArray[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xorArray[i] = xorArray[i - 1] ^ arr[i];
        }
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            if (queries[i][0] == 0) {
                result[i] = xorArray[queries[i][1]];
            } else {
                result[i] = xorArray[queries[i][0] - 1] ^ xorArray[queries[i][1]];
            }
        }
        return result;
    }
}
