package com.hupo.leetcode.array;

public class GiftMaxValue {

    public int maxValue(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int[][] result = new int[grid.length][grid[0].length];

        for (int i = grid.length - 1; i >= 0; i--) {
            for (int j = grid[0].length - 1; j >= 0; j--) {

                result[i][j] = grid[i][j];

                if (i + 1 <= grid.length - 1) {
                    result[i][j] = Math.max(result[i][j], grid[i][j] + result[i + 1][j]);
                }
                if (j + 1 <= grid[0].length - 1) {
                    result[i][j] = Math.max(result[i][j], grid[i][j] + result[i][j + 1]);
                }
            }
        }

        return result[0][0];

    }
}
