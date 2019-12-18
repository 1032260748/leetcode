package com.hupo.leetcode;


import java.util.List;

/**
 * 三张卡
 */
public class TriangleTrans {

    /**
     * 计算三角形顶点到底端的最小距离
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] result = new int[n];
        for (int i = 0; i <= n - 1; i++) {
            result[i] = triangle.get(n - 1).get(i);
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= triangle.get(i).size() - 1; j++) {
                result[j] = Math.min(result[j], result[j + 1]) + triangle.get(i).get(j);
            }
        }
        return result[0];
    }


}
