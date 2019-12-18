package com.hupo.leetcode;


/**
 * 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 */
public class MaxSquare {

    /**
     * 计算
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {

        if (matrix.length == 0) {
            return 0;
        }

        int result[][] = new int[matrix.length][matrix[0].length];

        int max = result[0][0];

        for (int i = 0; i <= matrix[0].length - 1; i++) {
            if (matrix[0][i] == '0') {
                result[0][i] = 0;
            } else {
                max = 1;
                result[0][i] = 1;
            }
        }

        for (int i = 0; i <= matrix.length - 1; i++) {
            if (matrix[i][0] == '0') {
                result[i][0] = 0;
            } else {
                max = 1;
                result[i][0] = 1;
            }
        }

        for (int i = 1; i <= matrix.length - 1; i++) {
            for (int j = 1; j <= matrix[0].length - 1; j++) {
                if (matrix[i][j] == '0') {
                    result[i][j] = 0;
                } else {
                    result[i][j] = min(result[i - 1][j], result[i - 1][j - 1], result[i][j - 1]) + 1;
                    if (result[i][j] > max) {
                        max = result[i][j];
                    }
                }
            }
        }

        return max * max;
    }


    int min(int a, int b, int c) {
        if (a <= b) {
            return a < c ? a : c;
        } else {
            return b < c ? b : c;
        }
    }

}
