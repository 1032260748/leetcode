package com.hupo.leetcode;


public class UniquePath {
    public int uniquePaths(int m, int n) {
        int[][] array = new int[m][n];

        for (int j = 0; j < n; j++) {
            array[0][j] = 1;
        }
        for (int i = 0; i < m; i++) {
            array[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }

        return array[m - 1][n - 1];
    }


    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] array = new int[m][n];

        boolean block = false;
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                block = true;
            } else {
                if (!block) {
                    array[0][j] = 1;
                }
            }
        }

        block = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                block = true;
            } else {
                if (!block) {
                    array[i][0] = 1;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                array[i][j] = array[i - 1][j] + array[i][j - 1];
            }
        }

        return array[m - 1][n - 1];
    }


}
