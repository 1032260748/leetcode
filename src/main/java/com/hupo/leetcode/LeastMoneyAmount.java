//package com.hupo.leetcode;
//
//
//public class LeastMoneyAmount {
//    public int getMoneyAmount(int n) {
//
//        int[][] result = new int[n + 1][n + 1];
//
//        for (int i = 1; i <= n; i++) {
//            result[i][i] = 0;
//
//            if (i + 1 <= n) {
//                result[i][i + 1] = i;
//            }
//        }
//
//        for (int i = 2; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (j + i <= n) {
//                    for (int m = j; m <= j + i; m++) {
//
//
//                    }
//                }
//            }
//
//        }
//    }
//
//
//    public static void main(String[] args) {
//
//    }
//
//
//    public int getMin(int start, int end, int[][] result) {
//
//        if (start == end) {
//            return 0;
//        }
//0
//        if (start == end - 1) {
//            return start;
//        }
//
//        int min=Integer.MAX_VALUE;
//
//
//        for (int i = start ; i <= end; i++) {
//
//
//
//            int left=0;
//
//            int right=0;
//            if (i>start)
//            {
//                left=i+result[start][i-1];
//            }
//1
//            if (i<end)
//            {
//                right=i+right[i+1]
//            }
//
//
//        }
//    }
//
//
//}
