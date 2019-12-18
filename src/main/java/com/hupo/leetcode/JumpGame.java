package com.hupo.leetcode;

import java.util.Stack;

public class JumpGame {
    public int canJump(int[] nums) {
        int result[] = new int[nums.length];

        for (int i = 1; i <= nums.length - 1; i++) {
            result[i] = Integer.MAX_VALUE;
        }

        result[0] = 0;
        for (int i = 1; i <= nums.length - 1; i++) {
            for (int j = 0; j < i; j++) {
                if (result[j] < Integer.MAX_VALUE) {
                    if (nums[j] >= i - j) {
                        if (result[j] + 1 < result[i]) {
                            result[i] = result[j] + 1;
                        }
                    }

                }
            }
        }

        return result[nums.length - 1];
    }


    public int largestRectangleArea(int[] heights) {
        int res = 0;
        Stack<Integer> st = new Stack<>();

        int[] temp = heights;
        heights = new int[temp.length + 1];

        for (int i = 0; i <= temp.length - 1; i++) {
            heights[i] = temp[i];
        }
        heights[temp.length] = 0;

        for (int i = 0; i < heights.length; ++i) {
            while (!st.empty() && heights[st.peek()] >= heights[i]) {
                int cur = st.peek();
                st.pop();
                res = Math.max(res, heights[cur] * (st.empty() ? i : (i - st.peek() - 1)));
            }
            st.push(i);
        }
        return res;
    }
}
