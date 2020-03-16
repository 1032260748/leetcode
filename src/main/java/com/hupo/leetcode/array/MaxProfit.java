package com.hupo.leetcode.array;

public class MaxProfit {

    public int maxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int max = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {

            if (prices[i] > minPrice) {
                max = Math.max(max, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
            }
        }

        return max;
    }

    public int maxProfitII(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int max = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > minPrice) {
                max = max + (prices[i] - minPrice);
                minPrice = prices[i];
            } else {
                minPrice = prices[i];
            }
        }
        return max;
    }


    public int maxProfitIII(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int max = 0;
        for (int i = 0; i < prices.length; i++) {
            int left = maxProfitIIIInner(prices, 0, i);
            int right = maxProfitIIIInner(prices, i, prices.length - 1);
            max = Math.max(max, left + right);
        }
        return max;
    }

    public int maxProfitIIIInner(int[] prices, int start, int end) {
        if (prices == null || end <= start) {
            return 0;
        }

        int max = 0;
        int minPrice = prices[start];
        for (int i = start; i <= end; i++) {
            if (prices[i] > minPrice) {
                max = Math.max(max, prices[i] - minPrice);
            } else {
                minPrice = prices[i];
            }
        }
        return max;
    }


    public int maxProfitIV(int k, int[] prices) {
        if (prices == null || prices.length == 0 || k <= 0) {
            return 0;
        }
        int[][][] result = new int[prices.length][prices.length][k + 1];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                result[i][j][1] = maxProfitIIIInner(prices, i, j);
            }
        }
        for (int n = 2; n <= k; n++) {
            for (int i = 0; i < prices.length; i++) {
                for (int j = 0; j < prices.length; j++) {
                    for (int temp = i; temp <= j; temp++) {
                        result[i][j][n] = Math.max(result[i][temp][1] + result[temp][j][n - 1], result[i][j][n]);
                    }
                }
            }
        }

        return result[0][prices.length - 1][k];
    }


}
